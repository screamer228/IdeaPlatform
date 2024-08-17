package ideaplatform.test_task.ideaplatform.domain.usecase

import ideaplatform.test_task.ideaplatform.domain.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

interface GetProductListByTitleUseCase {

    fun execute(title: String): Flow<List<ProductEntity>>
}