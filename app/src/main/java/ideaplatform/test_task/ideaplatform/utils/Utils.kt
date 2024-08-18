package ideaplatform.test_task.ideaplatform.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object Utils {

    fun Int.toNormalFormatDate(): String {
        val date = Date(this.toLong())
        val format = SimpleDateFormat(DATE_PATTERN, Locale.getDefault())
        return format.format(date)
    }
}

private const val DATE_PATTERN = "dd.MM.yyyy"