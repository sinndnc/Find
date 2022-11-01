package com.find.android.core.di.repository

import com.find.android.core.data.repository.SignUpRepositoryImpl
import com.find.android.core.domain.repository.SignUpRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class SignUpRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindLoginRepository(signUpRepositoryImpl: SignUpRepositoryImpl): SignUpRepository
}