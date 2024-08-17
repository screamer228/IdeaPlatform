package ideaplatform.test_task.ideaplatform.ui.screen.uistate

import ideaplatform.test_task.ideaplatform.ui.model.Product

data class UiState(
    val productList: List<Product> = listOf(),
    val searchField: String = ""
)
