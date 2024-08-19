package ideaplatform.test_task.ideaplatform.ui.ui_kit

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ideaplatform.test_task.ideaplatform.ui.theme.GrayDark

@Composable
fun CustomChipsRow(
    tags: List<String>,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        tags.forEach {
            CustomChip(
                text = it
            )
        }
    }
}

@Composable
fun CustomChip(
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .border(
                width = 1.dp,
                color = GrayDark,
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        Text(
            text = text,
            modifier = Modifier
                .padding(
                    vertical = 4.dp,
                    horizontal = 12.dp
                ),
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}
