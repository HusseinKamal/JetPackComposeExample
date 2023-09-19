package com.hussein.jetpackcomposeexample.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hussein.jetpackcomposeexample.model.ProductX

@Dao
interface ProductDao {
    @Query("SELECT * FROM product_table")
    fun getAllProducts():PagingSource<Int, ProductX>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProduct(products:List<ProductX>)

    @Query("DELETE FROM product_table")
    suspend fun deleteAllProducts()

}