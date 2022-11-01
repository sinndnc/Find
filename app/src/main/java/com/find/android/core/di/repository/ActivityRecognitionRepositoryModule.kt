package com.find.android.core.di.repository

import com.find.android.core.data.repository.ActivityRecognitionRepositoryImpl
import com.find.android.core.domain.repository.ActivityRecognitionRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ActivityRecognitionRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindActivityRecognitionRepositoryModule(activityRecognitionRepositoryImpl: ActivityRecognitionRepositoryImpl)
            : ActivityRecognitionRepository
}