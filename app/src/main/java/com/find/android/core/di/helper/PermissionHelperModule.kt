package com.find.android.core.di.helper

import com.find.android.core.util.permission.PermissionService
import com.find.android.core.util.permission.PermissionServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class PermissionHelperModule {

    @Binds
    @Singleton
    abstract fun bindPermissionHelper(permissionHelperImpl: PermissionServiceImpl): PermissionService
}