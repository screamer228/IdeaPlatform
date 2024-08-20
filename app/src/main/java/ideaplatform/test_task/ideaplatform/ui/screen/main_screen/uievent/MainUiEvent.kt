package ideaplatform.test_task.ideaplatform.ui.screen.main_screen.uievent

import ideaplatform.test_task.ideaplatform.ui.model.Product

sealed class MainUiEvent {
    data class OpenEditDialogClick(val product: Product) : MainUiEvent()
    data class OpenDeleteDialogClick(val productId: Int) : MainUiEvent()
    data class AcceptEditProductClick(val productId: Int, val newAmount: Int) : MainUiEvent()
    data class AcceptDeleteProductClick(val productId: Int) : MainUiEvent()
}
