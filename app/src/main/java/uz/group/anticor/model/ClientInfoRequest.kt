package uz.group.anticor.model

data class ClientInfoRequest(
    val telephone: String = "",
    val fio: String = "",
    val date: String = "",
    val fcm_token: String = "",
    val marketName: String = ""
)