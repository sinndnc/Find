package com.find.android.core.di.usecase

import com.find.android.core.domain.usecase.location.setting.LocationSettingUseCase
import com.find.android.core.domain.usecase.location.setting.LocationSettingUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LocationSettingHelperModule {


    @Binds
    @Singleton
    abstract fun bindLocationSettingHelper(locationSettingHelperImpl: LocationSettingUseCaseImpl): LocationSettingUseCase
}