package ideaplatform.test_task.ideaplatform.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ideaplatform.test_task.ideaplatform.BuildConfig
import ideaplatform.test_task.ideaplatform.data.dbo.ProductDbo

@Database(entities = [ProductDbo::class], version = 1)
@TypeConverters(Converters::class)
abstract class ProductDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao

    companion object {
        @Volatile
        private var INSTANCE: ProductDatabase? = null

        fun getDatabase(context: Context): ProductDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProductDatabase::class.java,
                    BuildConfig.PRODUCT_DATABASE_NAME
                ).createFromAsset(DATABASE_FILE_PATH)
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}

private const val DATABASE_FILE_PATH = "data.db"