package ideaplatform.test_task.ideaplatform.ui.ui_kit.card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ideaplatform.test_task.ideaplatform.R
import ideaplatform.test_task.ideaplatform.ui.model.Product
import ideaplatform.test_task.ideaplatform.ui.theme.BlueIcEdit
import ideaplatform.test_task.ideaplatform.ui.theme.RedIcDelete
import ideaplatform.test_task.ideaplatform.ui.theme.White
import ideaplatform.test_task.ideaplatform.ui.ui_kit.CustomChipsRow
import ideaplatform.test_task.ideaplatform.utils.noRippleClickable

@Composable
fun ProductCard(
    product: Product,
    modifier: Modifier = Modifier,
    onEditClicked: (Product) -> Unit,
    onDeleteClicked: (Product) -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 12.dp,
                    vertical = 12.dp
                ),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = product.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_edit),
                        contentDescription = null,
                        modifier = Modifier
                            .noRippleClickable { onEditClicked(product) },
                        tint = BlueIcEdit
                    )
                    Icon(
                        painter = painterResource(R.drawable.ic_delete),
                        contentDescription = null,
                        modifier = Modifier
                            .noRippleClickable { onDeleteClicked(product) },
                        tint = RedIcDelete
                    )
                }
            }
            CustomChipsRow(
                tags = product.tags
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier
                ) {
                    Text(
                        text = stringResource(R.string.on_storage),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = product.amount.toString()
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(
                            end = 40.dp
                        )
                ) {
                    Text(
                        text = stringResource(R.string.date_of_addition),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = product.time
                    )
                }
            }
        }
    }
}