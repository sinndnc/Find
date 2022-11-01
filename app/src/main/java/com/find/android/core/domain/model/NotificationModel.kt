package com.find.android.core.domain.model


data class NotificationModel(
    val to: String? = null,
    val data: Data? = null
)


data class Data(
    val chatType: ChatType,
    val title: String,
    val body: String,
)

enum class ChatType { Private, Group }