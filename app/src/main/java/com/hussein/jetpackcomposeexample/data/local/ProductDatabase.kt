package com.hussein.jetpackcomposeexample.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.hussein.jetpackcomposeexample.data.local.dao.ProductDao
import com.hussein.jetpackcomposeexample.data.local.dao.ProductRemoteKeysDao
import com.hussein.jetpackcomposeexample.model.Product
import com.hussein.jetpackcomposeexample.model.ProductRemoteKey
import com.hussein.jetpackcomposeexample.model.ProductX

@Database(entities = [ProductX::class, ProductRemoteKey::class], version = 1, exportSchema = false)
@TypeConverters(RoomTypeConverters::class)
abstract class ProductDatabase :RoomDatabase() {
    abstract fun productDao(): ProductDao
    abstract fun productRemoteKeyDao(): ProductRemoteKeysDao

}