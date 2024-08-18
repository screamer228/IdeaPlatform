package ideaplatform.test_task.ideaplatform.data.room

import androidx.room.Dao
import androidx.room.Query
import ideaplatform.test_task.ideaplatform.data.dbo.ProductDbo
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Query("SELECT * FROM item")
    fun getAllProducts(): Flow<List<ProductDbo>>

    @Query("SELECT * FROM item WHERE name = :title")
    fun getProductsByTitle(title: String): Flow<List<ProductDbo>>

    @Query("UPDATE item SET amount = :newAmount WHERE id = :productId")
    suspend fun updateProductAmountById(productId: Int, newAmount: Int)

    @Query("DELETE FROM item WHERE id = :productId")
    suspend fun deleteProductById(productId: Int)
}