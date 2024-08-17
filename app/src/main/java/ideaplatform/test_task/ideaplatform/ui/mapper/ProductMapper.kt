package ideaplatform.test_task.ideaplatform.ui.mapper

import ideaplatform.test_task.ideaplatform.domain.entity.ProductEntity
import ideaplatform.test_task.ideaplatform.ui.model.Product

class ProductMapper {

    fun mapEntityToUi(entity: ProductEntity): Product {
        return Product(
            id = entity.id,
            name = entity.name,
            time = entity.time,
            tags = entity.tags,
            amount = entity.amount
        )
    }
}