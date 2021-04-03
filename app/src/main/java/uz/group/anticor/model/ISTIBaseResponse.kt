package uz.group.anticor.model

data class ISTIBaseResponse<T>(
    val error: Boolean,
    val message: String,
    val items: T
)