package com.find.android.core.di.service

import com.find.android.core.data.remote.service.LoginServiceImpl
import com.find.android.core.domain.remote.service.LoginService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LoginServiceModule {

    @Binds
    @Singleton
    abstract fun bindLoginService(loginServiceImpl: LoginServiceImpl): LoginService
}