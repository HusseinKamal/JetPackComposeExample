package com.hussein.jetpackcomposeexample.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hussein.jetpackcomposeexample.screens.HomeScreen
import com.hussein.jetpackcomposeexample.screens.Screen
import com.hussein.jetpackcomposeexample.screens.SplashScreen

@Composable
fun SetupNavGraph(navHostController: NavHostController){
    NavHost(navController= navHostController, startDestination= Screen.Splash.route){
        composable(
            route= Screen.Splash.route
        ){
            SplashScreen(navHostController)
        }
        composable(
            route= Screen.Home.route
        ){
            HomeScreen(navHostController)
        }
    }
}

@Composable
@Preview
fun SetupNavGraphPreview(){

}