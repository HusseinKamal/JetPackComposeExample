package com.hussein.jetpackcomposeexample.model


import androidx.room.Embedded
import androidx.room.Entity
import com.hussein.jetpackcomposeexample.util.Constant
import com.hussein.jetpackcomposeexample.util.Constant.PRODUCT_TABLE
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Product(
    @SerialName("limit")
    var limit: Int,
    @Embedded
    @SerialName("products")
    var products: List<ProductX>,
    @SerialName("skip")
    var skip: Int,
    @SerialName("total")
    var total: Int
)