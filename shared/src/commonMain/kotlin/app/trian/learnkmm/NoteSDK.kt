package app.trian.learnkmm

import app.trian.learnkmm.entity.NoteModel
import io.ktor.client.HttpClient

class NoteSDK(
    private val driverFactory: DriverFactory,
    private val httpClient: HttpClient
) {
    private val api = NoteApi(httpClient)
    private val db = createDatabase(driverFactory)

    @Throws(
        Exception::class
    )
    suspend fun signInWithEmailAndPassword(
        email: String,
        password: String
    ): Pair<Boolean, String> {

        val res =
            api.signInWithEmail(email, password)
        return Pair(true, res)
    }

    @Throws(
        Exception::class
    )
    suspend fun getListAllNote(): List<NoteModel> {
        return db.noteQueries.selectAll()
            .executeAsList().map {
                NoteModel(
                    noteId = it.noteId,
                    noteName = it.noteName,
                    noteDescription = it.noteDescription
                )
            }
    }

    @Throws(
        Exception::class
    )
    suspend fun insertNewNote(data: NoteModel): Pair<Boolean, String> {
        db.noteQueries.insertNote(
            noteId = data.noteId,
            noteName = data.noteName,
            noteDescription = data.noteDescription
        )

        return Pair(
            true,
            "Success"
        )

    }

}