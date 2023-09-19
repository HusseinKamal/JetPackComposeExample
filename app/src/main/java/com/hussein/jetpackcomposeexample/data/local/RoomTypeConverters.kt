package com.hussein.jetpackcomposeexample.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class RoomTypeConverters {
    @TypeConverter
    fun fromArrayList(value: List<String?>): String {
        val gson = Gson()
        return gson.toJson(value)
    }

    @TypeConverter
    fun fromString(value: String?): List<String> {
        val gson = Gson()
        val type = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(value, type)
    }

}