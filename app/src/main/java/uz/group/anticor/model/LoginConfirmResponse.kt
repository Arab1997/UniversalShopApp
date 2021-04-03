package uz.group.anticor.model

data class LoginConfirmResponse(
    val token: String,
    val tuman: String?
)