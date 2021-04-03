package uz.group.anticor.model.request

data class LoginRequest(
    val phone: String,
    val code: String
)