package ideaplatform.test_task.ideaplatform.data.dbo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = TABLE_NAME)
data class ProductDbo(
    @PrimaryKey val id: Int,
    val name: String,
    val time: Long,
    val tags: List<String>,
    val amount: Int
)

private const val TABLE_NAME = "item"