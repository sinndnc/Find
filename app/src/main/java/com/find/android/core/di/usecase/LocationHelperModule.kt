package com.find.android.core.di.usecase

import com.find.android.core.domain.usecase.location.map.LocationHelper
import com.find.android.core.domain.usecase.location.map.LocationHelperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LocationHelperModule {


    @Binds
    @Singleton
    abstract fun bindLocationHelper(locationHelperImpl: LocationHelperImpl): LocationHelper
}