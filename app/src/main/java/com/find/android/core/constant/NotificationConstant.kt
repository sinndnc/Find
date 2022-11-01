package com.find.android.core.constant

object NotificationConstant {

    object ID {
        const val DEFAULT_NOTIFICATION_CHANNEL = "FIND_NOTIFICATION_CHANNEL"

        //***************** LOCATION CATEGORY ******************
        const val LOCATION_NOTIFICATION_CHANNEL = "FIND_LOCATION_CHANNEL"
        const val GROUP_LOCATION_NOTIFICATION_CHANNEL = "FIND_GROUP_LOCATION_NOTIFICATION_CHANNEL"

    }

    object GROUP {
        const val LOCATION_NOTIFICATION_CHANNEL = "Location"
    }

    object CHANNEL {
        //***************** LOCATION CATEGORY ******************
        const val GROUP_LOCATION_NOTIFICATION_CHANNEL = "Location Notification"
    }

    object DESCRIPTION {
        //***************** LOCATION CATEGORY ******************
        const val LOCATION_NOTIFICATION_CHANNEL = "Location channel description"
        const val GROUP_LOCATION_SERVICE_NOTIFICATION_CHANNEL = "Location channel description"
    }
}