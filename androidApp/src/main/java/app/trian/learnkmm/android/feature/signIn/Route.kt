package app.trian.learnkmm.android.feature.signIn

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

object SignIn {
    const val routeName = "SignIn"
}

fun NavGraphBuilder.routeSignIn(
    router: NavHostController,
) {
    composable(SignIn.routeName) {
        val viewModel =
            hiltViewModel<SignInViewModel>()

        val dataNotes by viewModel.dataNotes.collectAsState(
            listOf()
        )

        ScreenSignIn(
            notes=dataNotes,
            onSubmit = { email, password ->
                viewModel.insertNewNote { b, s ->
                }
            }
        )

    }
}