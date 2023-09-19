package com.hussein.jetpackcomposeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import androidx.paging.ExperimentalPagingApi
import coil.annotation.ExperimentalCoilApi
import com.hussein.jetpackcomposeexample.navigation.SetupNavGraph
import com.hussein.jetpackcomposeexample.ui.theme.JetPackComposeExampleTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalComposeApi
@ExperimentalMaterial3Api
@ExperimentalPagingApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    //private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        //val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        //splashScreen.setKeepOnScreenCondition{viewModel.isLoading.value}
        setContent {
            val navController = rememberNavController()
            JetPackComposeExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SetupNavGraph(navController)
                   /* Scaffold(
                        bottomBar = {
                            BottomAppBar(modifier = Modifier) {
                                BottomNavigationBar(navController = navController)
                            }
                        },
                    ) { innerPadding ->
                        Box(
                            modifier = Modifier.padding(
                                PaddingValues(
                                    0.dp,
                                    0.dp,
                                    0.dp,
                                    innerPadding.calculateBottomPadding()
                                )
                            )
                        ) {
                            NavHost(navController, startDestination = Screen.Home.HomeTab.route) {
                                Navigations(navController = navController)
                            }
                        }
                    }*/
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