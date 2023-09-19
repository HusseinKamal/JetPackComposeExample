package com.hussein.jetpackcomposeexample.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hussein.jetpackcomposeexample.util.Constant.PRODUCT_KEYS_TABLE

@Entity(tableName = PRODUCT_KEYS_TABLE)
data class ProductRemoteKey (
    @PrimaryKey(autoGenerate = false)
    val id:String,
    val prevPage:Int?,
    val nextPage:Int?,
)