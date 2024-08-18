package ideaplatform.test_task.ideaplatform.domain.usecase

import ideaplatform.test_task.ideaplatform.domain.entity.ProductEntity
import ideaplatform.test_task.ideaplatform.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow

class GetProductListByTitleUseCaseImpl(
    private val productRepository: ProductRepository
) : GetProductListByTitleUseCase {

    override fun execute(title: String): Flow<List<ProductEntity>> =
        productRepository.getProductListByTitle(title)
}