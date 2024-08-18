package ideaplatform.test_task.ideaplatform.data.repository

import ideaplatform.test_task.ideaplatform.data.mapper.ProductEntityMapper
import ideaplatform.test_task.ideaplatform.data.room.ProductDao
import ideaplatform.test_task.ideaplatform.domain.entity.ProductEntity
import ideaplatform.test_task.ideaplatform.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ProductRepositoryImpl(
    private val productDao: ProductDao,
    private val productEntityMapper: ProductEntityMapper
) : ProductRepository {

    override fun getProductList(): Flow<List<ProductEntity>> =
        productDao.getAllProducts()
            .map { productDboList ->
                productDboList.map { productEntityMapper.mapDboToEntity(it) }
            }

    override fun getProductListByTitle(title: String): Flow<List<ProductEntity>> =
        productDao.getProductsByTitle(title)
            .map { productDboList ->
                productDboList.map { productEntityMapper.mapDboToEntity(it) }
            }

    override suspend fun changeProductAmountById(productId: Int, newAmount: Int) {
        productDao.updateProductAmountById(productId, newAmount)
    }

    override suspend fun deleteProductById(productId: Int) {
        productDao.deleteProductById(productId)
    }
}