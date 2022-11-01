package com.find.android.core.di.repository

import com.find.android.core.data.repository.StorageRepositoryImpl
import com.find.android.core.domain.repository.StorageRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class StorageRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindStorageRepositoryModule(storageRepositoryImpl: StorageRepositoryImpl): StorageRepository
}