package app.trian.learnkmm.android

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import app.trian.learnkmm.android.feature.signIn.SignIn
import app.trian.learnkmm.android.feature.signIn.routeSignIn

@Composable
fun AppNavigation(
    applicationState: ApplicationState
) {
    NavHost(
        navController = applicationState.router,
        startDestination = SignIn.routeName
    ) {
        routeSignIn(applicationState.router)
    }
}