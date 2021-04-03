package uz.group.anticor.model

import java.io.Serializable

data class BasketModel(
    val id: String,
    var count: Int
): Serializable