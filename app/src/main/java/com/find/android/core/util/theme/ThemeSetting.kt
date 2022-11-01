package com.find.android.core.util.theme

import kotlinx.coroutines.flow.MutableStateFlow

enum class ThemeState { Light, Dark, System }

interface ThemeSetting {

    val themeState: MutableStateFlow<ThemeState>

    suspend fun changeTheme(newTheme: ThemeState)
}