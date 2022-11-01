package com.find.android.core.di.settings

import com.find.android.core.util.theme.ThemeSetting
import com.find.android.core.util.theme.ThemeSettingImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ThemeModule {

    @Binds
    @Singleton
    abstract fun bindThemeSetting(themeSettingImpl: ThemeSettingImpl): ThemeSetting
}