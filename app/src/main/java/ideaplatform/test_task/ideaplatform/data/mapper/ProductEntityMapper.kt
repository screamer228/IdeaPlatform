package ideaplatform.test_task.ideaplatform.data.mapper

import ideaplatform.test_task.ideaplatform.data.dbo.ProductDbo
import ideaplatform.test_task.ideaplatform.domain.entity.ProductEntity

interface ProductEntityMapper {

    fun mapDboToEntity(dbo: ProductDbo): ProductEntity
}