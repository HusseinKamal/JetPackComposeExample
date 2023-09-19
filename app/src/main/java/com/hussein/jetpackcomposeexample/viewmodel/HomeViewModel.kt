package com.hussein.jetpackcomposeexample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.paging.ExperimentalPagingApi
import com.hussein.jetpackcomposeexample.data.repository.RepositoryPaging
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@ExperimentalPagingApi
@HiltViewModel
class HomeViewModel @Inject constructor(
    repository: RepositoryPaging
): ViewModel() {
    val getAllProducts = repository.getAllProducts()
}