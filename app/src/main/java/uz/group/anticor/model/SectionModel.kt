package uz.group.anticor.model

import java.io.Serializable

data class SectionModel(
    val id: String,
    val name: String,
    val items: Int,
    val image: String?
): Serializable