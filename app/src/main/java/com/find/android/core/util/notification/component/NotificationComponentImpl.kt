package com.find.android.core.util.notification.component

import android.app.Notification
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationCompat.PRIORITY_HIGH
import com.find.android.R
import com.find.android.core.constant.NotificationConstant
import com.find.android.core.domain.model.NotificationModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class NotificationComponentImpl @Inject constructor(
    @ApplicationContext private val context: Context,
) : NotificationComponent {

    override val notificationManager: NotificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager


    override fun buildServiceNotification(activityContext: Context): Notification {
        val builder = NotificationCompat.Builder(activityContext, NotificationConstant.ID.GROUP_LOCATION_NOTIFICATION_CHANNEL)
            .setSilent(true)
            .setOngoing(true)
            .setShowWhen(false)
            .setPriority(PRIORITY_HIGH)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("Service is Running")
            .setCategory(Notification.CATEGORY_SERVICE)
        return builder.build()
    }


    override fun buildExpandableNotification(notificationModel: NotificationModel) {
        //TODO("Not yet implemented")
    }

    override fun buildGroupNotification(notificationModel: NotificationModel) {
        TODO("Not yet implemented")
    }

    override fun buildActionableNotification(notificationModel: NotificationModel) {
        TODO("Not yet implemented")
    }


}