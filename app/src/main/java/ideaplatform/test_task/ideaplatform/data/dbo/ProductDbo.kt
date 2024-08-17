package ideaplatform.test_task.ideaplatform.data.dbo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProductDbo(
    @PrimaryKey val id: Int,
    val name: String,
    val time: Int,
    val tags: List<String>,
    val amount: Int
)
