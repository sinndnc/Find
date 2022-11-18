package com.find.android.core.di.helper

import com.find.android.core.util.notification.NotificationService
import com.find.android.core.util.notification.NotificationServiceImpl
import com.find.android.core.util.notification.component.NotificationComponent
import com.find.android.core.util.notification.component.NotificationComponentImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NotificationHelperModule {

    @Binds
    @Singleton
    abstract fun bindNotificationHelper(notificationHelperImpl: NotificationServiceImpl): NotificationService

    @Binds
    @Singleton
    abstract fun bindNotificationComponentHelper(notificationComponentImpl: NotificationComponentImpl): NotificationComponent
}