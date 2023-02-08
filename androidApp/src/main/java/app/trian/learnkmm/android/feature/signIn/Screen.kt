package app.trian.learnkmm.android.feature.signIn

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import app.trian.learnkmm.android.base.BaseMainApp

@Composable
internal fun ScreenSignIn(
    modifier: Modifier = Modifier,
    onSubmit: (String, String) -> Unit = { _, _ -> }
) {
    Column {
        Text(text = "Login")

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