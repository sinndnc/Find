package com.find.android.feature.presentation.auth.login

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.find.android.core.domain.model.LoginModel
import com.find.android.core.domain.repository.LoginRepository
import com.find.android.feature.navigation.Content
import com.find.android.feature.util.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository
) : ViewModel() {

    private val _uiState: MutableState<UiState> = mutableStateOf(UiState.Initial)
    val uiState: MutableState<UiState> = _uiState
    val email: MutableState<String> = mutableStateOf("")
    val password: MutableState<String> = mutableStateOf("")
    val isVisible: MutableState<Boolean> = mutableStateOf(true)

    fun loginWithEmailAndPassword(loginModel: LoginModel, navController: NavController) {
        loginRepository.loginWithEmailAndPassword(loginModel).onEach { result ->
            result.onLoading {
                onLoginLoading()
            }.onSuccess { userModel ->
                onLoginSuccess(userModel, navController)
            }.onError { error ->
                onLoginError(error)
            }
        }.launchIn(viewModelScope)
    }

    private fun onLoginSuccess(userModel: String?, navController: NavController) {
        _uiState.value = UiState.Success
        Log.d("LoginTest", "$userModel - NONNULL")
        //navController.popBackStack()
        navController.navigate(Content.Home.route)

    }

    private fun onLoginLoading() {
        _uiState.value = UiState.Loading
    }

    private fun onLoginError(error: Throwable) {
        _uiState.value = UiState.Error
    }

    fun navigateToBackContent(navController: NavController){
        navController.navigateUp()
    }
}
