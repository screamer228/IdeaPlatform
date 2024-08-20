package ideaplatform.test_task.ideaplatform.ui.screen.main_screen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ideaplatform.test_task.ideaplatform.domain.usecase.ChangeProductAmountByIdUseCase
import ideaplatform.test_task.ideaplatform.domain.usecase.DeleteProductByIdUseCase
import ideaplatform.test_task.ideaplatform.domain.usecase.GetProductListUseCase
import ideaplatform.test_task.ideaplatform.ui.mapper.ProductMapper
import ideaplatform.test_task.ideaplatform.ui.model.Product
import ideaplatform.test_task.ideaplatform.ui.screen.main_screen.common.NeedDialogState
import ideaplatform.test_task.ideaplatform.ui.screen.main_screen.uievent.MainUiEvent
import ideaplatform.test_task.ideaplatform.ui.screen.main_screen.uistate.MainUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private val getProductListUseCase: GetProductListUseCase,
    private val changeProductAmountByIdUseCase: ChangeProductAmountByIdUseCase,
    private val deleteProductByIdUseCase: DeleteProductByIdUseCase,
    private val productMapper: ProductMapper
) : ViewModel() {

    private val _uiState = MutableStateFlow(MainUiState())
    private val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    fun getUiState(): StateFlow<MainUiState> = uiState

    init {
        getProductList()
    }

    fun postUiEvent(uiEvent: MainUiEvent) {
        when (uiEvent) {
            is MainUiEvent.OpenEditDialogClick -> {
                updateNeedToShowDialog(NeedDialogState.NeedEditDialog(uiEvent.product))
            }

            is MainUiEvent.OpenDeleteDialogClick -> {
                updateNeedToShowDialog(NeedDialogState.NeedDeleteDialog(uiEvent.productId))
            }

            is MainUiEvent.AcceptEditProductClick -> {
                changeProductAmount(uiEvent.productId, uiEvent.newAmount)
                resetNeedToShowDialog()
            }

            is MainUiEvent.AcceptDeleteProductClick -> {
                deleteProduct(uiEvent.productId)
                resetNeedToShowDialog()
            }
        }
    }

    fun updateSearchField(newSearchQuery: String) {
        _uiState.update { state ->
            state.copy(
                searchQuery = newSearchQuery,
                searchResultProductList = filterProductList(newSearchQuery, state.productList)
            )
        }
    }

    fun resetNeedToShowDialog() {
        _uiState.update {
            it.copy(needToShowDialog = NeedDialogState.NoNeedDialog)
        }
    }

    private fun getProductList() {
        viewModelScope.launch {
            getProductListUseCase.execute()
                .flowOn(Dispatchers.IO)
                .map { productEntityList ->
                    productEntityList.map { productMapper.mapEntityToUi(it) }
                }
                .collect { productList ->
                    _uiState.update { state ->
                        state.copy(
                            searchResultProductList = filterProductList(
                                state.searchQuery,
                                productList
                            ),
                            productList = productList
                        )
                    }
                }
        }
    }

    private fun filterProductList(searchQuery: String, productList: List<Product>): List<Product> {
        return if (searchQuery.isEmpty()) {
            productList
        } else {
            productList.filter { product ->
                product.name.contains(searchQuery, ignoreCase = true)
            }
        }
    }

    private fun updateNeedToShowDialog(needDialogState: NeedDialogState) {
        _uiState.update {
            it.copy(needToShowDialog = needDialogState)
        }
    }

    private fun changeProductAmount(productId: Int, newAmount: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            changeProductAmountByIdUseCase.execute(productId, newAmount)
            changeProductAmountLocally(productId, newAmount)
        }
    }

    private fun changeProductAmountLocally(productId: Int, newAmount: Int) {
        _uiState.update { state ->
            val updatedProductList = state.productList.map { product ->
                if (product.id == productId) {
                    product.copy(amount = newAmount)
                } else {
                    product
                }
            }
            state.copy(productList = updatedProductList)
        }
    }

    private fun deleteProduct(productId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteProductByIdUseCase.execute(productId)
            deleteProductLocally(productId)
        }
    }

    private fun deleteProductLocally(productId: Int) {
        _uiState.update { state ->
            val updatedProductList = state.productList.filterNot { it.id == productId }
            state.copy(productList = updatedProductList)
        }
    }
}