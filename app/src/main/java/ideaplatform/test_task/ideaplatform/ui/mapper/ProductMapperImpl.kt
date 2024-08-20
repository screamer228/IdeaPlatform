package ideaplatform.test_task.ideaplatform.ui.mapper

import ideaplatform.test_task.ideaplatform.domain.entity.ProductEntity
import ideaplatform.test_task.ideaplatform.ui.model.Product
import ideaplatform.test_task.ideaplatform.utils.Extensions.toNormalFormatDate

class ProductMapperImpl : ProductMapper {

    override fun mapEntityToUi(entity: ProductEntity): Product {
        return Product(
            id = entity.id,
            name = entity.name,
            time = entity.time.toNormalFormatDate(),
            tags = entity.tags,
            amount = entity.amount
        )
    }
}