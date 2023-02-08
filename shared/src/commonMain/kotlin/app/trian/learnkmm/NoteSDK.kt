package app.trian.learnkmm

import app.trian.learnkmm.entity.NoteModel
import io.ktor.client.HttpClient

class NoteSDK(
    private val driverFactory: DriverFactory,
    private val httpClient: HttpClient
) {
    private val api = NoteApi(httpClient)
    private val db = createDatabase(driverFactory)

    suspend fun signInWithEmailAndPassword(
        email: String,
        password: String
    ): Pair<Boolean, String> {

        api.signInWithEmail(email,password)
        return Pair(true, "Tes")
    }

    suspend fun getListAllNote(): List<NoteModel> =
        with(db) {
            noteQueries.selectAll()
                .executeAsList().map {
                    NoteModel(
                        noteId = it.noteId,
                        noteName = it.noteName,
                        noteDescription = it.noteDescription
                    )
                }
        }

    suspend fun insertNewNote(data: NoteModel) =
        with(db) {
            noteQueries.insertNote(
                noteId = data.noteId,
                noteName = data.noteName,
                noteDescription = data.noteDescription
            )
        }

}