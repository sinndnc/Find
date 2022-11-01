package com.find.android.feature.presentation.main.profile

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.SwipeableState
import androidx.lifecycle.ViewModel
import com.find.android.core.domain.usecase.user.UserUseCase
import com.find.android.feature.presentation.main.home.views.AppBarSheetState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    userUseCase: UserUseCase
) : ViewModel() {

    val userInfo = userUseCase.userModel

    @OptIn(ExperimentalMaterialApi::class)
    suspend fun backToHomeContent(state: SwipeableState<AppBarSheetState>) {
        state.animateTo(AppBarSheetState.Collapsed)
    }

}