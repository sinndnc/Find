package com.find.android.core.di.usecase

import com.find.android.core.domain.usecase.user.UserUseCase
import com.find.android.core.domain.usecase.user.UserUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UserHelperModule {

    @Binds
    @Singleton
    abstract fun bindUserInformation(userInformationImpl: UserUseCaseImpl): UserUseCase
}