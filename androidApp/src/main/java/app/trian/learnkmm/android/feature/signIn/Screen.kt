package app.trian.learnkmm.android.feature.signIn

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import app.trian.learnkmm.android.base.BaseMainApp
import app.trian.learnkmm.entity.NoteModel

@Composable
internal fun ScreenSignIn(
    modifier: Modifier = Modifier,
    notes:List<NoteModel> = listOf(),
    onSubmit: (String, String) -> Unit = { _, _ -> }
) {
    Column {
        Text(text = "Login")

        LazyColumn(content = {
            items(notes){
                Text(text = it.noteName)
            }
        })
        Button(onClick = { onSubmit("", "") }) {
            Text(text = "Proses")
        }
    }
}

@Preview
@Composable
fun PreviewScreenSignIn() {
    BaseMainApp {
        ScreenSignIn()
    }

}