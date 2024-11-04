package com.aoi.presentation.navigation.application

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
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
    val commonEnterTransition = slideInHorizontally(
        initialOffsetX = { 1100 },
        animationSpec = tween(800)
    )

    val commonExitTransition = slideOutHorizontally(
        targetOffsetX = { -1100 },
        animationSpec = tween(800)
    )
    NavHost(
        navController = navController,
        startDestination = AppNavigation.SubmittingEmail.route
    ) {
        composable(AppNavigation.SubmittingEmail.route) {
            SubmittingEmailScreen(
                onNavigateToSignInScreen = { navController.navigate(AppNavigation.SignIn.route) },
                onNavigateToVerifyingTokenScreen = { navController.navigate(AppNavigation.VerifyingToken.route) }
            )
        }
        composable(
            route =AppNavigation.VerifyingToken.route,
            enterTransition = { commonEnterTransition },
            exitTransition = { commonExitTransition }
        ) {
            //VerifyingTokenScreen()
        }
        composable(
            AppNavigation.RegisteringAccount.route,
            enterTransition = { commonEnterTransition },
            exitTransition = { commonExitTransition }
        ) {
            //RegisteringAccountScreen()
        }
        composable(
            AppNavigation.SignIn.route,
            enterTransition = { commonEnterTransition },
            exitTransition = { commonExitTransition },
            ) {
            //SignInScreen()
        }
    }
}