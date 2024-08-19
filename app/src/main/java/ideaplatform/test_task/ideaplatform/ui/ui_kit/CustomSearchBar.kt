package ideaplatform.test_task.ideaplatform.ui.ui_kit

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ideaplatform.test_task.ideaplatform.R
import ideaplatform.test_task.ideaplatform.ui.theme.GrayDark
import ideaplatform.test_task.ideaplatform.ui.theme.White
import ideaplatform.test_task.ideaplatform.utils.noRippleClickable

@Composable
fun CustomSearchBar(
    searchQuery: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = searchQuery,
        onValueChange = { onValueChange(it) },
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = White,
                shape = RoundedCornerShape(4.dp)
            ),
        placeholder = {
            Text(
                text = "Поиск товаров",
                color = Color.DarkGray,
                fontSize = 14.sp
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.ic_search),
                contentDescription = null,
                tint = GrayDark
            )
        },
        trailingIcon = {
            if (searchQuery.isNotEmpty()) {
                Icon(
                    painter = painterResource(R.drawable.ic_clear),
                    contentDescription = null,
                    modifier = Modifier
                        .noRippleClickable { onValueChange("") },
                    tint = GrayDark
                )
            }
        },
        singleLine = true,
        textStyle = TextStyle.Default.copy(
            color = Color.DarkGray,
            fontSize = 14.sp
        ),
        colors = OutlinedTextFieldDefaults.colors(
        ).copy(
            focusedContainerColor = White,
            unfocusedContainerColor = White,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            focusedPlaceholderColor = GrayDark,
            unfocusedPlaceholderColor = GrayDark,
            cursorColor = GrayDark,

        )
    )
}