package ideaplatform.test_task.ideaplatform.ui.mapper

import ideaplatform.test_task.ideaplatform.domain.entity.ProductEntity
import ideaplatform.test_task.ideaplatform.ui.model.Product

interface ProductMapper {

    fun mapEntityToUi(entity: ProductEntity): Product
}