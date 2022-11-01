package com.find.android.core.di.service

import com.find.android.core.data.local.storage.LocalStorageServiceImpl
import com.find.android.core.data.remote.storage.RemoteStorageServiceImpl
import com.find.android.core.domain.local.storage.LocalStorageService
import com.find.android.core.domain.remote.storage.RemoteStorageService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class StorageServiceModule {

    @Binds
    @Singleton
    abstract fun bindRemoteStorageService(remoteStorageServiceImpl: RemoteStorageServiceImpl): RemoteStorageService

    @Binds
    @Singleton
    abstract fun bindLocalStorageService(localStorageServiceImpl: LocalStorageServiceImpl): LocalStorageService


}