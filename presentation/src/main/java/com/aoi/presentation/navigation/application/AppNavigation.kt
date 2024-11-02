package com.aoi.presentation.navigation.application

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aoi.presentation.sign_up.submitting_email.SubmittingEmailScreen

sealed class AppNavigation(val route: String) {
    data object SubmittingEmail : AppNavigation("submitting_email")
    data object VerifyingToken : AppNavigation("verifying_token")
    data object RegisteringAccount : AppNavigation("registering_account")
    data object SignIn : AppNavigation("sign_in")
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppNavigation.SubmittingEmail.route
    ) {
        composable(AppNavigation.SubmittingEmail.route) {
            SubmittingEmailScreen()
        }
        composable(AppNavigation.VerifyingToken.route) {
            //VerifyingTokenScreen()
        }
        composable(AppNavigation.RegisteringAccount.route) {
            //RegisteringAccountScreen()
        }
        composable(AppNavigation.SignIn.route) {
            //SignInScreen()
        }
    }
}