package com.hussein.jetpackcomposeexample.navigation
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hussein.jetpackcomposeexample.screens.HomeRootNavigationScreen
import com.hussein.jetpackcomposeexample.util.Routes

@Composable
fun SetupNavGraph(navHostController: NavHostController){
    NavHost(
        navController = navHostController,
        route = Routes.ROOT,
        startDestination = Routes.SPLASH_ROUTE
    ) {
        splashNavGraph(navController = navHostController)
        composable(route = Routes.HOME_ROUTE) {
            HomeRootNavigationScreen()
        }
    }
}

@Composable
@Preview
fun SetupNavGraphPreview(){

}