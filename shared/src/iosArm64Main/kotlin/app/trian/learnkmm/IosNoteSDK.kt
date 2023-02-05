package app.trian.learnkmm

import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin

fun createIOSSDK(driverFactory: DriverFactory): NoteSDK {
    return NoteSDK(
        driverFactory = driverFactory,
        httpClient = HttpClient(
            Darwin
        ) {
            engine {
                configureRequest {
                    setAllowsCellularAccess(true)
                }
            }
        }
    )
}
