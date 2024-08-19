package ideaplatform.test_task.ideaplatform

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.core.view.WindowCompat
import ideaplatform.test_task.ideaplatform.ui.screen.main_screen.MainScreen
import ideaplatform.test_task.ideaplatform.ui.theme.BlueLight
import ideaplatform.test_task.ideaplatform.ui.theme.IdeaPlatformTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setSystemBarsColor()

        setContent {
            IdeaPlatformTheme {
                Scaffold(
                    containerColor = BlueLight
                ) { innerPadding ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(
                                top = innerPadding.calculateTopPadding(),
                                bottom = innerPadding.calculateBottomPadding()
                            )
                    ) {
                        MainScreen()
                    }
                }
            }
        }
    }

    private fun setSystemBarsColor() {
        val windowInsetsController = WindowCompat.getInsetsController(window, window.decorView)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.statusBarColor = BlueLight.toArgb()
            window.navigationBarColor = BlueLight.toArgb()

            windowInsetsController.apply {
                isAppearanceLightStatusBars = true
                isAppearanceLightNavigationBars = true
            }
        } else {
            window.statusBarColor = BlueLight.toArgb()
            window.navigationBarColor = BlueLight.toArgb()
        }
    }
}