package com.find.android.core.di.usecase

import com.find.android.core.domain.usecase.user.UserHelper
import com.find.android.core.domain.usecase.user.UserHelperImpl
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
    abstract fun bindUserInformation(userInformationImpl: UserHelperImpl): UserHelper
}