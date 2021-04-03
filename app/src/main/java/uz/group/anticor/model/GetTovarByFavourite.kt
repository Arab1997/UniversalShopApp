package uz.group.anticor.model

data class IdValModel(
    val id: String
)

data class GetTovarByFavourite(
    val skladid: Int,
    val items: List<IdValModel>
)