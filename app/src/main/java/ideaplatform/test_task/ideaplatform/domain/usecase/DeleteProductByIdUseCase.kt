package ideaplatform.test_task.ideaplatform.domain.usecase

interface DeleteProductByIdUseCase {

    suspend fun execute(productId: Int)
}