package com.hussein.jetpackcomposeexample.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.hussein.jetpackcomposeexample.data.local.ProductDatabase
import com.hussein.jetpackcomposeexample.data.paging.ProductRemoteMediator
import com.hussein.jetpackcomposeexample.data.remote.ProductAPI
import com.hussein.jetpackcomposeexample.model.ProductX
import com.hussein.jetpackcomposeexample.util.Constant
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ExperimentalPagingApi
class RepositoryPaging @Inject constructor(
    private val productAPI: ProductAPI,
    private val productDataBase: ProductDatabase
) {
    fun getAllProducts(): Flow<PagingData<ProductX>> {
        val pagingSourceFactory= {productDataBase.productDao().getAllProducts()}
        return Pager(
            config = PagingConfig(pageSize = Constant.ITEM_PER_PAGE),
            remoteMediator = ProductRemoteMediator(productAPI,productDataBase),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

}