package ideaplatform.test_task.ideaplatform.utils

import java.text.SimpleDateFormat
import java.util.Locale

object Extensions {

    fun Long.toNormalFormatDate(): String {
        val format = SimpleDateFormat(DATE_PATTERN, Locale.getDefault())
        return format.format(this)
    }
}

private const val DATE_PATTERN = "dd.MM.yyyy"