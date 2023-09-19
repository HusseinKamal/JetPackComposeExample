package com.hussein.jetpackcomposeexample.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hussein.jetpackcomposeexample.model.ProductRemoteKey

@Dao
interface ProductRemoteKeysDao {

    @Query("SELECT * FROM product_remote_keys_table WHERE id=:id")
    suspend fun getRemoteKeys(id : String): ProductRemoteKey

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addRemoteKeys(remoteKeys : List<ProductRemoteKey>)

    @Query("DELETE FROM product_remote_keys_table")
    suspend fun deleteKeys()

}