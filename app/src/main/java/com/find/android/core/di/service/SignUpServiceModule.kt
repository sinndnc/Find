package com.find.android.core.di.service

import com.find.android.core.data.remote.service.SignUpServiceImpl
import com.find.android.core.domain.remote.service.SignUpService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class SignUpServiceModule {

    @Binds
    @Singleton
    abstract fun bindSignUpService(signUpServiceImpl: SignUpServiceImpl): SignUpService
}