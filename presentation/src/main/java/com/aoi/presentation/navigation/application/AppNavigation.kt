package com.aoi.presentation.navigation.application

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aoi.presentation.sign_up.SignUpScreen

sealed class AppNavigation(val route: String) {
    data object SignUp : AppNavigation("sign_up")
    data object SignIn : AppNavigation("sign_in")
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppNavigation.SignUp.route
    ) {
        composable(AppNavigation.SignUp.route) {
            SignUpScreen()
        }
        composable(AppNavigation.SignIn.route) {
            //SignInScreen()
        }
    }
}