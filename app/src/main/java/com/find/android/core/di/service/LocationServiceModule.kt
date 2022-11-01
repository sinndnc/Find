package com.find.android.core.di.service

import com.find.android.core.util.location.LocationService
import com.find.android.core.util.location.LocationServiceImpl
import com.find.android.core.util.recognition.ActivityRecognitionService
import com.find.android.core.util.recognition.ActivityRecognitionServiceImpl
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
    abstract fun bindLocationDetectActivity(locationDetectActivityImpl: ActivityRecognitionServiceImpl): ActivityRecognitionService


    @Binds
    @Singleton
    abstract fun bindLocationService(locationServiceImpl: LocationServiceImpl): LocationService

}