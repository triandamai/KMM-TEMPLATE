package app.trian.learnkmm

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import okhttp3.Interceptor


fun createAndroidSDK(driverFactory: DriverFactory, interceptor: Interceptor): NoteSDK {
    return NoteSDK(
        driverFactory = driverFactory,
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


