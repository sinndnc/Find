package com.find.android.core.di.module

import com.find.android.core.util.annotation.DefaultCoroutineScope
import com.find.android.core.util.annotation.IoCoroutineScope
import com.find.android.core.util.annotation.MainCoroutineScope
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object CoroutineScopeModule {

    @Provides
    @DefaultCoroutineScope
    fun providesDefaultCoroutineScope(): CoroutineScope = CoroutineScope(Dispatchers.Default)

    @Provides
    @IoCoroutineScope
    fun providesIoCoroutineScope(): CoroutineScope = CoroutineScope(Dispatchers.IO)

    @Provides
    @MainCoroutineScope
    fun providesMainCoroutineScope(): CoroutineScope = CoroutineScope(Dispatchers.Main)
}