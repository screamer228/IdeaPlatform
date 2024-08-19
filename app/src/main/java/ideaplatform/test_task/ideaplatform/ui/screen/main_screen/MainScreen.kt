package ideaplatform.test_task.ideaplatform.ui.screen.main_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ideaplatform.test_task.ideaplatform.ui.screen.delete_dialog.DeleteDialog
import ideaplatform.test_task.ideaplatform.ui.screen.edit_dialog.EditDialog
import ideaplatform.test_task.ideaplatform.ui.screen.main_screen.common.NeedDialogState
import ideaplatform.test_task.ideaplatform.ui.screen.main_screen.uievent.MainUiEvent
import ideaplatform.test_task.ideaplatform.ui.screen.main_screen.viewmodel.MainViewModel
import ideaplatform.test_task.ideaplatform.ui.theme.BlueLight
import ideaplatform.test_task.ideaplatform.ui.ui_kit.CustomSearchBar
import ideaplatform.test_task.ideaplatform.ui.ui_kit.lazycolumn.ProductsLazyColumn
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = koinViewModel()
) {

    val uiState by viewModel.getUiState().collectAsStateWithLifecycle()

    val focusManager = LocalFocusManager.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures {
                    focusManager.clearFocus()
                }
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = BlueLight
                )
        ) {
            Text(
                text = "Список товаров",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(
                        top = 26.dp,
                        bottom = 20.dp
                    ),
                fontSize = 22.sp
            )
        }
        CustomSearchBar(
            searchQuery = uiState.searchQuery,
            modifier = Modifier
                .padding(
                    start = 12.dp,
                    top = 16.dp,
                    end = 12.dp,
                    bottom = 10.dp
                ),
            onValueChange = { viewModel.updateSearchField(it) }
        )

        ProductsLazyColumn(
            productList = if (uiState.searchQuery.isNotEmpty()) {
                uiState.searchResultProductList
            } else {
                uiState.productList
            },
            modifier = Modifier
                .padding(
                    horizontal = 12.dp
                ),
            onEditClicked = { viewModel.postUiEvent(MainUiEvent.OpenEditDialogClick(it)) },
            onDeleteClicked = { viewModel.postUiEvent(MainUiEvent.OpenDeleteDialogClick(it.id)) }
        )
    }

    when (uiState.needToShowDialog) {
        is NeedDialogState.NeedEditDialog -> {
            EditDialog(
                productArg = (uiState.needToShowDialog as NeedDialogState.NeedEditDialog).product,
                onDismissRequest = { viewModel.resetNeedToShowDialog() },
                onAccept = { product, newAmount ->
                    viewModel.postUiEvent(MainUiEvent.AcceptEditProductClick(product.id, newAmount))
                }
            )
        }

        is NeedDialogState.NeedDeleteDialog -> {
            DeleteDialog(
                productIdArg = (uiState.needToShowDialog as NeedDialogState.NeedDeleteDialog).productId,
                onDismissRequest = { viewModel.resetNeedToShowDialog() },
                onAccept = { productId ->
                    viewModel.postUiEvent(MainUiEvent.AcceptDeleteProductClick(productId))
                }
            )
        }

        else -> {}
    }
}
