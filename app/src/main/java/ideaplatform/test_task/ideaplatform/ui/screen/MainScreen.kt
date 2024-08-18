package ideaplatform.test_task.ideaplatform.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
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

    Column(
        modifier = modifier
            .fillMaxSize()
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
                        vertical = 24.dp
                    ),
                fontSize = 22.sp
            )
            CustomSearchBar(
                searchValue = uiState.searchField,
                onValueChange = { viewModel.updateSearchField(it) }
            )
        }
        ProductsLazyColumn(
            productList = uiState.productList,
            modifier = Modifier
                .padding(
                    horizontal = 12.dp
                )
        )
    }
}