package ideaplatform.test_task.ideaplatform.domain.usecase

import ideaplatform.test_task.ideaplatform.domain.repository.ProductRepository

class ChangeProductAmountByIdUseCaseImpl(
    private val productRepository: ProductRepository
) : ChangeProductAmountByIdUseCase {

    override suspend fun execute(productId: Int, newAmount: Int) {
        productRepository.changeProductAmountById(productId, newAmount)
    }
}