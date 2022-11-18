package com.find.android.core.util.notification

import android.app.NotificationManager

interface NotificationService {

    val notificationManager: NotificationManager

    fun createNotificationChannelIfNotExists(channelId: String, channelName: String, channelDescription: String, groupId: String)

    fun createNotificationChannelGroupIfNotExists(groupId: String, groupName: String, groupDescription: String)

    fun createChatNotificationChannel()


}