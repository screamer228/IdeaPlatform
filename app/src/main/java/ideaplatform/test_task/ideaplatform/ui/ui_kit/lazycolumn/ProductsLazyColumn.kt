package ideaplatform.test_task.ideaplatform.ui.ui_kit.lazycolumn

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ideaplatform.test_task.ideaplatform.ui.model.Product
import ideaplatform.test_task.ideaplatform.ui.ui_kit.card.ProductCard

@Composable
fun ProductsLazyColumn(
    productList: List<Product>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
    ) {
        itemsIndexed(productList) { index, item ->
            ProductCard(
                product = item,
                modifier = Modifier
                    .padding(
                        vertical = 10.dp
                    )
            )
        }
    }
}