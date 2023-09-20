package com.hussein.jetpackcomposeexample.data.remote

import com.hussein.jetpackcomposeexample.model.Product
import retrofit2.http.GET

interface ProductAPI{

    @GET("/products")
    suspend fun getAllProducts():Product

}