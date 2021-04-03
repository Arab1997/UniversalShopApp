package uz.group.anticor.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ProductModel(
    val id: String,
    val name: String,
    val image: String?,
    val price: Double,
    @SerializedName("ostatka")
    val productCount: Int,
    val information: String,
    var favourite: Boolean = false,
    var cartCount: Int = 0
): Serializable