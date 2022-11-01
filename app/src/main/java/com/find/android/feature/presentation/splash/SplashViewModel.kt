package com.find.android.feature.presentation.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.find.android.core.domain.usecase.splash.SplashUseCase
import com.find.android.feature.navigation.Content
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val splashUseCase: SplashUseCase,
) : ViewModel() {

    fun isUserLogged(navController: NavController) {
        viewModelScope.launch {
            navController.popBackStack()
            if (splashUseCase.invoke()) {
                navController.navigate(Content.MAIN_GRAPH)
            } else {
                navController.navigate(Content.AUTH_GRAPH)
            }
        }
    }
}
