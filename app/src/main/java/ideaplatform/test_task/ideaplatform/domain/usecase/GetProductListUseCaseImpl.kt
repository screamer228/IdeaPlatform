package ideaplatform.test_task.ideaplatform.domain.usecase

import ideaplatform.test_task.ideaplatform.domain.entity.ProductEntity
import ideaplatform.test_task.ideaplatform.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow

class GetProductListUseCaseImpl(
    private val productRepository: ProductRepository
) : GetProductListUseCase {

    override fun execute(): Flow<List<ProductEntity>> =
        productRepository.getProductList()
}