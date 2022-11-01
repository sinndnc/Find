package com.find.android.core.di.usecase

import com.find.android.core.domain.usecase.splash.CheckIsUserLoggedHelper
import com.find.android.core.domain.usecase.splash.CheckIsUserLoggedHelperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class SplashUseCaseModule(){

    @Binds
    @Singleton
    abstract fun bindIsUserLoggedUseCase( checkIsUserLoggedImpl: CheckIsUserLoggedHelperImpl) : CheckIsUserLoggedHelper
}
