package ideaplatform.test_task.ideaplatform.domain.usecase

import ideaplatform.test_task.ideaplatform.domain.repository.ProductRepository

class DeleteProductByIdUseCaseImpl(
    private val productRepository: ProductRepository
) : DeleteProductByIdUseCase {

    override suspend fun execute(productId: Int) {
        productRepository.deleteProductById(productId)
    }
}