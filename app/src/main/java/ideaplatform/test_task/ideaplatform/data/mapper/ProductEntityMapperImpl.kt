package ideaplatform.test_task.ideaplatform.data.mapper

import ideaplatform.test_task.ideaplatform.data.dbo.ProductDbo
import ideaplatform.test_task.ideaplatform.domain.entity.ProductEntity

class ProductEntityMapperImpl : ProductEntityMapper {

    override fun mapDboToEntity(dbo: ProductDbo): ProductEntity {
        return ProductEntity(
            id = dbo.id,
            name = dbo.name,
            time = dbo.time,
            tags = dbo.tags,
            amount = dbo.amount
        )
    }
}