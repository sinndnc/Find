package com.find.android.core.di.settings

import com.find.android.core.data.local.dataStore.DataStoreSettingImpl
import com.find.android.core.domain.local.dataStore.DataStoreSetting
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataStoreSettingModule {

    @Binds
    @Singleton
    abstract fun bindDataStoreSetting(dataStoreSettingImpl: DataStoreSettingImpl): DataStoreSetting
}