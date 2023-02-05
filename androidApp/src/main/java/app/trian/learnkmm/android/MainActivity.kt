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
import app.trian.learnkmm.createAndroidSDK
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.chuckerteam.chucker.api.RetentionManager
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val collector = ChuckerCollector(
            context = this@MainActivity,
            showNotification = true,
            retentionPeriod = RetentionManager.Period.ONE_HOUR
        )
        val chuckerBuilder = ChuckerInterceptor.Builder(this@MainActivity)
            .collector(
                collector
            )
            .build()

        val sdk = createAndroidSDK(
            driverFactory = DriverFactory(this@MainActivity),
            interceptor =chuckerBuilder
        )

        setContent {
            LaunchedEffect(key1 = sdk, block = {
                Log.e("HOHO","HEHE")
               sdk.api.signInWithEmail("sa","")
            })
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GreetingView("Hellow worled")
                }
            }
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}
