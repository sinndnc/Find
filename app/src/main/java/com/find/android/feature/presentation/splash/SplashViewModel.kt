package com.find.android.feature.presentation.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.find.android.core.domain.usecase.splash.CheckIsUserLoggedHelper
import com.find.android.feature.navigation.Content
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val checkIsUserLoggedHelper: CheckIsUserLoggedHelper,
) : ViewModel() {

    fun isUserLogged(navController: NavController) {
        viewModelScope.launch {
            navController.popBackStack()
            if (checkIsUserLoggedHelper.invoke()) {
                navController.navigate(Content.MAIN_GRAPH)
            } else {
                navController.navigate(Content.AUTH_GRAPH)
            }
        }
    }
}
