package ideaplatform.test_task.ideaplatform.app

import android.app.Application
import ideaplatform.test_task.ideaplatform.di.appModule
import ideaplatform.test_task.ideaplatform.di.dataModule
import ideaplatform.test_task.ideaplatform.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class KoinApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@KoinApp)
            modules(
                listOf(
                    appModule,
                    domainModule,
                    dataModule
                )
            )
        }
    }
}