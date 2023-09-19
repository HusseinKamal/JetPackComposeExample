package com.hussein.jetpackcomposeexample.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.ExperimentalPagingApi
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import com.hussein.jetpackcomposeexample.viewmodel.HomeViewModel

@ExperimentalCoilApi
@ExperimentalPagingApi
@Composable
fun HomeTab(navHostController: NavHostController, homeViewModel: HomeViewModel = hiltViewModel()) {
    val getAllProducts = homeViewModel.getAllProducts.collectAsLazyPagingItems()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    androidx.compose.material.Text(
                        text = "Home",
                        color = Color.White
                    )
                },
                backgroundColor = androidx.compose.material3.MaterialTheme.colorScheme.primary,
            )
        },
        content = {padding ->
            Column(
                modifier = Modifier
                    .padding(padding)){
                ListContent(items = getAllProducts)
            }
        }
    )
}

@Composable
@Preview
fun HomeTopBarPreview() {
    TopAppBar(
        title = {
            androidx.compose.material.Text(
                text = "Home",
                color = MaterialTheme.colors.primary
            )
        },
        backgroundColor = MaterialTheme.colors.primary,
    )
}