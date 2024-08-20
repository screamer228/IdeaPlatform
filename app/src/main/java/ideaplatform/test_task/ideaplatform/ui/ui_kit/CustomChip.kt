package ideaplatform.test_task.ideaplatform.ui.ui_kit

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ideaplatform.test_task.ideaplatform.ui.theme.GrayDark

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CustomChipsRow(
    tags: List<String>,
    modifier: Modifier = Modifier
) {
    FlowRow(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(6.dp),
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
                    horizontal = 14.dp
                ),
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}
