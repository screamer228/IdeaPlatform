package ideaplatform.test_task.ideaplatform.domain.usecase

interface ChangeProductAmountByIdUseCase {

    suspend fun execute(productId: Int, newAmount: Int)
}