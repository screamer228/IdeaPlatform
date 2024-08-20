package ideaplatform.test_task.ideaplatform.domain.entity

data class ProductEntity(
    val id: Int,
    val name: String,
    val time: Long,
    val tags: List<String>,
    val amount: Int
)
