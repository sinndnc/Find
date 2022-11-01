package com.find.android.core.di.service

import com.find.android.core.util.recognition.ActivityDetectService
import com.find.android.core.util.recognition.ActivityDetectServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LocationServiceModule {

    @Binds
    @Singleton
    abstract fun bindLocationDetectActivity(locationDetectActivityImpl: ActivityDetectServiceImpl): ActivityDetectService

}