package com.hussein.jetpackcomposeexample.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.hussein.jetpackcomposeexample.screens.SplashScreen
import com.hussein.jetpackcomposeexample.util.Routes

fun NavGraphBuilder.splashNavGraph(navController: NavHostController) {
    navigation(
        route = Routes.SPLASH_ROUTE,
        startDestination = Routes.SPLASH_SCREEN
    ) {
        composable(route = Routes.SPLASH_SCREEN) {
            SplashScreen(navController= navController)
        }
    }
}