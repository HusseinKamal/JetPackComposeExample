package com.hussein.jetpackcomposeexample.data.di

import android.content.Context
import androidx.room.Room
import com.hussein.jetpackcomposeexample.data.local.ProductDatabase
import com.hussein.jetpackcomposeexample.data.local.RoomTypeConverters
import com.hussein.jetpackcomposeexample.util.Constant.PRODUCT_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) : ProductDatabase {
        return Room.databaseBuilder(context, ProductDatabase::class.java,PRODUCT_DATABASE).build()

    }
}