package ideaplatform.test_task.ideaplatform.ui.screen.delete_dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import ideaplatform.test_task.ideaplatform.R
import ideaplatform.test_task.ideaplatform.ui.theme.BlueDark
import ideaplatform.test_task.ideaplatform.ui.theme.GrayDark
import ideaplatform.test_task.ideaplatform.ui.theme.GrayLight
import ideaplatform.test_task.ideaplatform.utils.noRippleClickable

@Composable
fun DeleteDialog(
    productIdArg: Int,
    onDismissRequest: () -> Unit,
    onAccept: (productId: Int) -> Unit
) {
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
                painter = painterResource(R.drawable.ic_warning),
                contentDescription = null,
                modifier = Modifier
                    .padding(
                        top = 20.dp
                    ),
                tint = GrayDark
            )
            Text(
                text = "Удаление товара",
                fontSize = 22.sp
            )
            Text(
                text = "Вы действительно хотите удалить выбранный товар?",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 24.dp
                    ),
                color = GrayDark,
                fontSize = 13.sp,
                fontWeight = FontWeight.W400
            )
            Row(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(
                        top = 12.dp,
                        end = 40.dp,
                        bottom = 36.dp
                    ),
                horizontalArrangement = Arrangement.spacedBy(40.dp)
            ) {
                Text(
                    text = "Нет",
                    modifier = Modifier
                        .noRippleClickable { onDismissRequest() },
                    color = BlueDark,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                )
                Text(
                    text = "Да",
                    modifier = Modifier
                        .noRippleClickable { onAccept(productIdArg) },
                    color = BlueDark,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}
