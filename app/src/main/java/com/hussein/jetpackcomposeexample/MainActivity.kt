package com.hussein.jetpackcomposeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.hussein.jetpackcomposeexample.navigation.SetupNavGraph
import com.hussein.jetpackcomposeexample.ui.theme.JetPackComposeExampleTheme
import com.hussein.jetpackcomposeexample.viewmodel.SplashViewModel

class MainActivity : ComponentActivity() {

    //private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        //val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        //splashScreen.setKeepOnScreenCondition{viewModel.isLoading.value}

        setContent {
            JetPackComposeExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    SetupNavGraph(navHostController = navController)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetPackComposeExampleTheme {
        Greeting("Android")
    }
}