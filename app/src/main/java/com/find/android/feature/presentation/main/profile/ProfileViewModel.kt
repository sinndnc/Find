package com.find.android.feature.presentation.main.profile

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.SwipeableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.find.android.core.domain.usecase.user.UserUseCase
import com.find.android.core.util.theme.ThemeSetting
import com.find.android.core.util.theme.ThemeState
import com.find.android.feature.presentation.main.home.views.AppBarSheetState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    userUseCase: UserUseCase,
    val themeSetting: ThemeSetting,
) : ViewModel() {

    val userInfo = userUseCase.userModel
    val openDialog = mutableStateOf(false)

    @OptIn(ExperimentalMaterialApi::class)
    suspend fun backToHomeContent(state: SwipeableState<AppBarSheetState>) {
        state.animateTo(AppBarSheetState.Collapsed)
    }

    fun toggleTheme() {
        viewModelScope.launch {
            themeSetting.changeTheme(
                if (themeSetting.themeState.value == ThemeState.Dark)
                    ThemeState.Light else ThemeState.Dark
            )
        }
    }

}