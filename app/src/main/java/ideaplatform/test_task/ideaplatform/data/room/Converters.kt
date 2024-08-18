package ideaplatform.test_task.ideaplatform.data.room

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    private val gson = Gson()

    @TypeConverter
    fun fromString(value: String?): List<String>? {
        return value?.let {
            val listType = object : TypeToken<List<String>>() {}.type
            gson.fromJson(it, listType)
        }
    }

    @TypeConverter
    fun fromList(list: List<String>?): String? {
        return list?.let { gson.toJson(it) }
    }
}