package ideaplatform.test_task.ideaplatform.ui.screen.main_screen.uistate

import ideaplatform.test_task.ideaplatform.ui.model.Product
import ideaplatform.test_task.ideaplatform.ui.screen.main_screen.common.NeedDialogState

data class MainUiState(
    val productList: List<Product> = listOf(),
    val searchQuery: String = "",
    val searchResultProductList: List<Product> = listOf(),
    val needToShowDialog: NeedDialogState = NeedDialogState.NoNeedDialog
)