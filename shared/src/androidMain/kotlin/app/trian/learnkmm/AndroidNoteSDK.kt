package app.trian.learnkmm

import android.content.Context
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import okhttp3.Interceptor


fun createAndroidSDK(context:Context, interceptor: Interceptor): NoteSDK {
    return NoteSDK(
        driverFactory = DriverFactory(context),
        httpClient = HttpClient(
            OkHttp
        ) {
            engine {
                config { followRedirects(true) }
                addInterceptor(interceptor)
            }
        }
    )
}


