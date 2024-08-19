package ideaplatform.test_task.ideaplatform.ui.screen.edit_dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import ideaplatform.test_task.ideaplatform.R
import ideaplatform.test_task.ideaplatform.ui.model.Product
import ideaplatform.test_task.ideaplatform.ui.theme.BlueDark
import ideaplatform.test_task.ideaplatform.ui.theme.GrayDark
import ideaplatform.test_task.ideaplatform.ui.theme.GrayLight
import ideaplatform.test_task.ideaplatform.utils.noRippleClickable

@Composable
fun EditDialog(
    productArg: Product,
    onDismissRequest: () -> Unit,
    onAccept: (product: Product, newAmount: Int) -> Unit
) {

    var productAmount by mutableStateOf(productArg.amount)

    Dialog(
        onDismissRequest = { onDismissRequest() }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 4.dp
                )
                .background(
                    color = GrayLight,
                    shape = RoundedCornerShape(20.dp)
                ),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_settings),
                contentDescription = null,
                modifier = Modifier
                    .padding(
                        top = 20.dp
                    ),
                tint = GrayDark
            )
            Text(
                text = "Количество товара",
                fontSize = 22.sp
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_minus),
                    contentDescription = null,
                    modifier = Modifier
                        .size(32.dp)
                        .noRippleClickable(
                            enabled = productAmount > 0,
                            onClick = { productAmount -= UNIT_OF_CHANGE_AMOUNT }
                        ),
                    tint = BlueDark,
                )
                Text(
                    text = productAmount.toString(),
                    fontSize = 18.sp
                )
                Icon(
                    painter = painterResource(R.drawable.ic_plus),
                    contentDescription = null,
                    modifier = Modifier
                        .size(32.dp)
                        .noRippleClickable { productAmount += UNIT_OF_CHANGE_AMOUNT },
                    tint = BlueDark
                )
            }
            Row(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(
                        top = 12.dp,
                        end = 36.dp,
                        bottom = 36.dp
                    ),
                horizontalArrangement = Arrangement.spacedBy(32.dp)
            ) {
                Text(
                    text = "Отмена",
                    modifier = Modifier
                        .noRippleClickable { onDismissRequest() },
                    color = BlueDark,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "Принять",
                    modifier = Modifier
                        .noRippleClickable { onAccept(productArg, productAmount) },
                    color = BlueDark,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

private const val UNIT_OF_CHANGE_AMOUNT = 1