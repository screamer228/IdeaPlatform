package ideaplatform.test_task.ideaplatform.ui.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ideaplatform.test_task.ideaplatform.domain.usecase.ChangeProductAmountByIdUseCase
import ideaplatform.test_task.ideaplatform.domain.usecase.DeleteProductByIdUseCase
import ideaplatform.test_task.ideaplatform.domain.usecase.GetProductListByTitleUseCase
import ideaplatform.test_task.ideaplatform.domain.usecase.GetProductListUseCase
import ideaplatform.test_task.ideaplatform.ui.mapper.ProductMapper
import ideaplatform.test_task.ideaplatform.ui.screen.uistate.UiState
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
    private val getProductListByTitleUseCase: GetProductListByTitleUseCase,
    private val changeProductAmountByIdUseCase: ChangeProductAmountByIdUseCase,
    private val deleteProductByIdUseCase: DeleteProductByIdUseCase,
    private val productMapper: ProductMapper
) : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    private val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun getUiState(): StateFlow<UiState> = uiState

    init {
        Log.d(
            "MainViewModel check",
            "ViewModel создан с зависимостями: " +
                    "$getProductListUseCase," +
                    " $getProductListByTitleUseCase," +
                    " $changeProductAmountByIdUseCase," +
                    " $deleteProductByIdUseCase," +
                    " $productMapper"
        )
        getProductList()
    }

    fun getProductList() {
        viewModelScope.launch {
            getProductListUseCase.execute()
                .flowOn(Dispatchers.IO)
                .map { productEntityList ->
                    productEntityList.map { productMapper.mapEntityToUi(it) }
                }
                .collect { productList ->
                    _uiState.update {
                        it.copy(productList = productList)
                    }
                }
        }
    }

    fun updateSearchField(searchFieldValue: String) {
        _uiState.update {
            it.copy(searchField = searchFieldValue)
        }
    }

    fun getProductListByTitle(title: String) {
        viewModelScope.launch {
            getProductListByTitleUseCase.execute(title)
                .flowOn(Dispatchers.IO)
                .map { productEntityList ->
                    productEntityList.map { productMapper.mapEntityToUi(it) }
                }
                .collect { productList ->
                    _uiState.update {
                        it.copy(productList = productList)
                    }
                }
        }
    }

    fun changeProductAmountById(productId: Int, newAmount: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            changeProductAmountByIdUseCase.execute(productId, newAmount)
        }
    }

    fun deleteProductById(productId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteProductByIdUseCase.execute(productId)
        }
    }
}