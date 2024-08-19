package ideaplatform.test_task.ideaplatform.ui.screen.main_screen.common

import ideaplatform.test_task.ideaplatform.ui.model.Product

sealed class NeedDialogState {
    data object NoNeedDialog : NeedDialogState()
    data class NeedEditDialog(val product: Product) : NeedDialogState()
    data class NeedDeleteDialog(val productId: Int) : NeedDialogState()
}