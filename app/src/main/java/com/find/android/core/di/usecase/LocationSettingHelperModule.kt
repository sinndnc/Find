package com.find.android.core.di.usecase

import com.find.android.core.domain.usecase.location.setting.LocationSettingHelper
import com.find.android.core.domain.usecase.location.setting.LocationSettingHelperImpl
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
    abstract fun bindLocationSettingHelper(locationSettingHelperImpl: LocationSettingHelperImpl): LocationSettingHelper
}