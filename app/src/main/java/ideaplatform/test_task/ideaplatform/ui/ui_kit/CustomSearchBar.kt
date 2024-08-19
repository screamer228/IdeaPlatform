package ideaplatform.test_task.ideaplatform.ui.ui_kit

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.TextFieldLineLimits
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ideaplatform.test_task.ideaplatform.R
import ideaplatform.test_task.ideaplatform.ui.theme.GrayDark
import ideaplatform.test_task.ideaplatform.ui.theme.White

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CustomSearchBar(
    searchValue: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = 12.dp
            )
            .background(
                color = White,
                shape = RoundedCornerShape(4.dp)
            )
            .border(
                width = 1.dp,
                color = GrayDark,
                shape = RoundedCornerShape(4.dp)
            )
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_search),
            contentDescription = null,
            modifier = Modifier
                .padding(
                    vertical = 16.dp,
                    horizontal = 12.dp
                ),
            tint = GrayDark
        )
        Box(
            modifier = Modifier
                .weight(1f),
            contentAlignment = Alignment.CenterStart
        ) {
            if (searchValue.isEmpty()) {
                Text(
                    text = "Поиск товаров",
                    color = Color.DarkGray,
                    fontSize = 14.sp
                )
            }
            BasicTextField2(
                value = searchValue,
                onValueChange = { onValueChange(it) },
                lineLimits = TextFieldLineLimits.SingleLine,
                textStyle = TextStyle.Default.copy(
                    color = Color.DarkGray,
                    fontSize = 14.sp
                ),
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}