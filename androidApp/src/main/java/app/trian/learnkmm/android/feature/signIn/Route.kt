package app.trian.learnkmm.android.feature.signIn

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

        ScreenSignIn(
            onSubmit = { email, password ->
                viewModel.signInWithEmailAndPassword(
                    email,
                    password
                ) { success, message ->
                }
            }
        )

    }
}