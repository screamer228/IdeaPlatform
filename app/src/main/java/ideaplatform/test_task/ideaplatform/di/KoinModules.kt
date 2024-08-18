package ideaplatform.test_task.ideaplatform.di

import ideaplatform.test_task.ideaplatform.data.mapper.ProductEntityMapper
import ideaplatform.test_task.ideaplatform.data.mapper.ProductEntityMapperImpl
import ideaplatform.test_task.ideaplatform.data.repository.ProductRepositoryImpl
import ideaplatform.test_task.ideaplatform.data.room.ProductDao
import ideaplatform.test_task.ideaplatform.data.room.ProductDatabase
import ideaplatform.test_task.ideaplatform.domain.repository.ProductRepository
import ideaplatform.test_task.ideaplatform.domain.usecase.ChangeProductAmountByIdUseCase
import ideaplatform.test_task.ideaplatform.domain.usecase.ChangeProductAmountByIdUseCaseImpl
import ideaplatform.test_task.ideaplatform.domain.usecase.DeleteProductByIdUseCase
import ideaplatform.test_task.ideaplatform.domain.usecase.DeleteProductByIdUseCaseImpl
import ideaplatform.test_task.ideaplatform.domain.usecase.GetProductListByTitleUseCase
import ideaplatform.test_task.ideaplatform.domain.usecase.GetProductListByTitleUseCaseImpl
import ideaplatform.test_task.ideaplatform.domain.usecase.GetProductListUseCase
import ideaplatform.test_task.ideaplatform.domain.usecase.GetProductListUseCaseImpl
import ideaplatform.test_task.ideaplatform.ui.mapper.ProductMapper
import ideaplatform.test_task.ideaplatform.ui.mapper.ProductMapperImpl
import ideaplatform.test_task.ideaplatform.ui.screen.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<MainViewModel> { MainViewModel(get(), get(), get(), get(), get()) }
    single<ProductMapper> { ProductMapperImpl() }
}

val domainModule = module {
    factory<GetProductListUseCase> { GetProductListUseCaseImpl(get()) }
    factory<GetProductListByTitleUseCase> { GetProductListByTitleUseCaseImpl(get()) }
    factory<ChangeProductAmountByIdUseCase> { ChangeProductAmountByIdUseCaseImpl(get()) }
    factory<DeleteProductByIdUseCase> { DeleteProductByIdUseCaseImpl(get()) }
}

val dataModule = module {
    single<ProductRepository> { ProductRepositoryImpl(get(), get()) }
    single<ProductEntityMapper> { ProductEntityMapperImpl() }
    single<ProductDao> { get<ProductDatabase>().productDao() }
    single<ProductDatabase> { ProductDatabase.getDatabase(get()) }
}