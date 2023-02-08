package app.trian.learnkmm.android

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import app.trian.learnkmm.DriverFactory
import app.trian.learnkmm.android.base.BaseMainApp
import app.trian.learnkmm.createAndroidSDK
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.chuckerteam.chucker.api.RetentionManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val collector = ChuckerCollector(
            context = this@MainActivity,
            showNotification = true,
            retentionPeriod = RetentionManager.Period.ONE_HOUR
        )
        val chuckerBuilder =
            ChuckerInterceptor.Builder(this@MainActivity)
                .collector(
                    collector
                )
                .build()

        val sdk = createAndroidSDK(
            context = this@MainActivity,
            interceptor = chuckerBuilder
        )

        setContent {
            LaunchedEffect(key1 = sdk, block = {

            })
            BaseMainApp {
                AppNavigation(applicationState = it)
            }
        }
    }
}
