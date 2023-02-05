package app.trian.learnkmm

import io.ktor.client.HttpClient

class NoteSDK(
    private val driverFactory: DriverFactory,
    private val httpClient: HttpClient
) {
    val api = NoteApi(httpClient)
    val db = createDatabase(driverFactory)

    
}