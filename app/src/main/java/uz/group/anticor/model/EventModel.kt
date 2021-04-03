package uz.group.anticor.model

data class EventModel<T>(
    val event: Int,
    val data: T
)