package com.find.android.core.di.usecase

import com.find.android.core.domain.usecase.splash.SplashUseCase
import com.find.android.core.domain.usecase.splash.SplashUseCaseImpl
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
    abstract fun bindIsUserLoggedUseCase( checkIsUserLoggedImpl: SplashUseCaseImpl) : SplashUseCase
}
