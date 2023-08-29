package com.hussein.jetpackcomposeexample.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.hussein.jetpackcomposeexample.R

@Composable
fun SplashScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary), contentAlignment = Alignment.Center
    ) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.splash))

        var isPlaying by remember{
            mutableStateOf(true)
        }
        val logoAnimationState = animateLottieCompositionAsState(composition = composition,isPlaying = isPlaying)

       LaunchedEffect(key1 = logoAnimationState.progress){
            if(logoAnimationState.progress == 0f)
            {
                isPlaying = true
            }
            else if(logoAnimationState.progress == 1f){
                isPlaying = false
            }
        }

        LottieAnimation(
            composition = composition,
            progress = { logoAnimationState.progress },
        )
        if (!isPlaying) { //progress mean number of iterations has been done
            navController.navigate(Screen.Home.route){
                popUpTo(navController.graph.id){//This for remove any back stack or previous pages
                    inclusive = false
                }
            }
        }
    }
}