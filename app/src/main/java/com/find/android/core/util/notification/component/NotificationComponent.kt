package com.find.android.core.util.notification.component

import android.app.Notification
import android.app.NotificationManager
import android.content.Context
import com.find.android.core.domain.model.NotificationModel


interface NotificationComponent {

    val notificationManager: NotificationManager

    fun buildServiceNotification(activityContext: Context ): Notification

    fun buildExpandableNotification(notificationModel: NotificationModel)

    fun buildGroupNotification(notificationModel: NotificationModel)

    fun buildActionableNotification(notificationModel: NotificationModel)

}