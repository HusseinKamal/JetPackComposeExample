package com.hussein.jetpackcomposeexample.data.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.hussein.jetpackcomposeexample.data.local.ProductDatabase
import com.hussein.jetpackcomposeexample.data.remote.ProductAPI
import com.hussein.jetpackcomposeexample.model.ProductRemoteKey
import com.hussein.jetpackcomposeexample.model.ProductX
import javax.inject.Inject

@ExperimentalPagingApi
class ProductRemoteMediator @Inject constructor(
    private val productAPI: ProductAPI,
    private val productDataBase: ProductDatabase
    ):RemoteMediator<Int, ProductX>(){

    private val productDao = productDataBase.productDao()
    private val productRemoteKeyDao = productDataBase.productRemoteKeyDao()


    override suspend fun load(loadType: LoadType, state: PagingState<Int, ProductX>): MediatorResult {
        return try {
            val currentPage= when(loadType){
                LoadType.REFRESH -> {
                    val remoteKeys= getRemoteKeyClosestToCurrentPosition(state)
                    remoteKeys?.nextPage?.minus(1) ?: 1
                }
                LoadType.PREPEND -> {
                    val remoteKeys= getRemoteKeyForFirstItem(state)
                    val prev=remoteKeys?.prevPage?:
                    return MediatorResult.Success (endOfPaginationReached = remoteKeys !=null)
                    prev
                }
                LoadType.APPEND -> {
                    val remoteKeys= getRemoteKeyForLastItem(state)
                    val next=remoteKeys?.nextPage?:
                    return MediatorResult.Success (endOfPaginationReached = remoteKeys !=null)
                    next
                }
            }

            val response= productAPI.getAllProducts()
            val endReachPagination= response.products.isEmpty()

            val prevPage = if(currentPage == 1) null else currentPage-1
            val nextPage = if(endReachPagination) null else currentPage+1
            productDataBase.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    productDao.deleteAllProducts()
                    productRemoteKeyDao.deleteKeys()
                }
                val keys = response.products.map { product ->
                    ProductRemoteKey(
                        id = product.id.toString(),
                        prevPage = prevPage,
                        nextPage = nextPage
                    )
                }
                productRemoteKeyDao.addRemoteKeys(remoteKeys = keys)
                productDao.addProduct(products = response.products)
            }
            MediatorResult.Success(endReachPagination)

        }
        catch (e:Exception){
            return MediatorResult.Error(e)
        }
    }
    private suspend fun getRemoteKeyClosestToCurrentPosition(state: PagingState<Int, ProductX>) : ProductRemoteKey?{
        return state.anchorPosition?.let { position->

            state.closestItemToPosition(position)?.id?.let {id->
                productRemoteKeyDao.getRemoteKeys(id= id.toString())
            }
        }
    }

    private suspend fun getRemoteKeyForFirstItem(state: PagingState<Int, ProductX>) : ProductRemoteKey?{
        return state.pages.firstOrNull {it.data.isEmpty()}?.data?.firstOrNull()?.let { product ->
            productRemoteKeyDao.getRemoteKeys(id= product.id.toString())
        }
    }

    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, ProductX>) : ProductRemoteKey?{
        return state.pages.lastOrNull {it.data.isEmpty()}?.data?.lastOrNull()?.let { product ->
            productRemoteKeyDao.getRemoteKeys(id= product.id.toString())
        }
    }
}