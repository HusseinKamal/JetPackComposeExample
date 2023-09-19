package com.hussein.jetpackcomposeexample.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.paging.ExperimentalPagingApi
import com.hussein.jetpackcomposeexample.screens.BottomBarRootNavigationScreen
import com.hussein.jetpackcomposeexample.screens.HomeTab
import com.hussein.jetpackcomposeexample.screens.Profile
import com.hussein.jetpackcomposeexample.util.Routes

@ExperimentalPagingApi
@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Routes.HOME_ROUTE,
        startDestination = BottomBarRootNavigationScreen.Home.route
    ) {
        composable(route = BottomBarRootNavigationScreen.Home.route) {
           HomeTab(navHostController = navController)
        }
        composable(route = BottomBarRootNavigationScreen.Profile.route) {
           Profile(navHostController = navController)
        }
    }
}