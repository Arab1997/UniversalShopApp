package uz.group.anticor.model

data class NewsModel(
    val data: String,
    val title: String,
    val news: String,
    var checked: Boolean = false
)