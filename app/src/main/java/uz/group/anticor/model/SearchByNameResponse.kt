package uz.group.anticor.model

data class SearchByNameResponse(
    val features: List<FeaturesItem>?
)

data class FeaturesItem(
    val geometry: GeometryItem?,
    val properties: GeoObject?
)

data class GeometryItem(
    val coordinates: List<Double>?
)

data class GeoObject(
    val name: String?,
    val description: String?
)