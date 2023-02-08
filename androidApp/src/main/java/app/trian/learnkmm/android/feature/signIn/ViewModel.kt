package app.trian.learnkmm.android.feature.signIn

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.trian.learnkmm.NoteSDK
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val noteSDK: NoteSDK
) : ViewModel() {

    fun signInWithEmailAndPassword(
        email: String,
        password: String,
        result: (Boolean, String) -> Unit
    ) = with(viewModelScope) {
        launch {
            noteSDK.signInWithEmailAndPassword("","")
        }
    }
}