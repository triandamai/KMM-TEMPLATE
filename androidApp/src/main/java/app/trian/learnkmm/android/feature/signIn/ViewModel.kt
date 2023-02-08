package app.trian.learnkmm.android.feature.signIn

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.trian.learnkmm.NoteSDK
import app.trian.learnkmm.entity.NoteModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val noteSDK: NoteSDK
) : ViewModel() {

    private val _dataNotes =
        MutableStateFlow<List<NoteModel>>(listOf())
    val dataNotes = _dataNotes.asStateFlow()

    init {
        getAllNotes()
    }

    fun signInWithEmailAndPassword(
        email: String,
        password: String,
        result: (Boolean, String) -> Unit
    ) = with(viewModelScope) {
        launch {
            noteSDK.signInWithEmailAndPassword(
                "",
                ""
            )
        }
    }

    fun insertNewNote(
        result: (Boolean, String) -> Unit
    ) = with(viewModelScope) {
        launch {
            noteSDK.insertNewNote(
                NoteModel(
                    noteId = UUID.randomUUID().toString(),
                    noteName = "Ini Name",
                    noteDescription = "Ini Description"
                )
            )
            getAllNotes()
        }
    }

    fun getAllNotes() = with(viewModelScope) {
        launch {
            val data = noteSDK.getListAllNote()
            _dataNotes.emit(data)
        }
    }
}