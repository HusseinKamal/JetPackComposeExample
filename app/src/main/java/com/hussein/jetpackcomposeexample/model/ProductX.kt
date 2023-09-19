package com.hussein.jetpackcomposeexample.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hussein.jetpackcomposeexample.util.Constant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = Constant.PRODUCT_TABLE)
data class ProductX(
    @SerialName("brand")
    var brand: String,
    @SerialName("category")
    var category: String,
    @SerialName("description")
    var description: String,
    @SerialName("discountPercentage")
    var discountPercentage: Double,
    @PrimaryKey(autoGenerate = false)
    @SerialName("id")
    var id: Int,
    @SerialName("images")
    var images: List<String>,
    @SerialName("price")
    var price: Int,
    @SerialName("rating")
    var rating: Double,
    @SerialName("stock")
    var stock: Int,
    @SerialName("thumbnail")
    var thumbnail: String,
    @SerialName("title")
    var title: String
)