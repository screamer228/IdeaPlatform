package ideaplatform.test_task.ideaplatform.domain.repository

import ideaplatform.test_task.ideaplatform.domain.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    fun getProductList(): Flow<List<ProductEntity>>

    fun getProductListByTitle(title: String): Flow<List<ProductEntity>>

    suspend fun changeProductAmountById(productId: Int, newAmount: Int)

    suspend fun deleteProductById(productId: Int)
}