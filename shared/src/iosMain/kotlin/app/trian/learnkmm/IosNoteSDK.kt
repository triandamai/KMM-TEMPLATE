package app.trian.learnkmm

import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin

class CreateIOSSDK() {
    fun createNoteSDK() = NoteSDK(
        driverFactory = DriverFactory(),
        httpClient = HttpClient() {}
    )
}
