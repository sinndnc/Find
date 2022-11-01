package com.find.android.feature.presentation.auth.signup

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.find.android.core.domain.model.SignUpModel
import com.find.android.core.domain.repository.SignUpRepository
import com.find.android.feature.navigation.Content
import com.find.android.feature.util.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpRepository: SignUpRepository
) : ViewModel() {

    private val _uiState: MutableState<UiState> = mutableStateOf(UiState.Initial)
    val uiState: MutableState<UiState> = _uiState

    val name: MutableState<String> = mutableStateOf("")
    val email: MutableState<String> = mutableStateOf("")
    val password: MutableState<String> = mutableStateOf("")


    fun navigateToBackContent(navController: NavController) {
        navController.navigateUp()
    }

    fun createUserWithEmailAndPassword(signUpModel: SignUpModel,navController: NavController) {
        signUpRepository.createUserWithEmailAndPassword(signUpModel).onEach { result ->
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
        Log.d("SignUp Test", "$userModel - NONNULL")
        //navController.popBackStack()
        navController.navigate(Content.Home.route)

    }

    private fun onLoginLoading() {
        _uiState.value = UiState.Loading
    }

    private fun onLoginError(error: Throwable) {
        _uiState.value = UiState.Error
    }

}