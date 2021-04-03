package uz.group.anticor.api

data class BaseResponse<T>(
    val error: Boolean,
    val message: String?,
    val error_code: Int?,
    val data: T
)