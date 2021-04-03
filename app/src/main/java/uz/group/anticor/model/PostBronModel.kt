package uz.group.anticor.model

import java.io.Serializable

data class PostBronModel(
    val id: String,
    val number: Int,
    val PaymeURL: String?
): Serializable