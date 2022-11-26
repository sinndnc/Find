package com.find.android.feature.presentation.main.language

import androidx.compose.runtime.MutableState
import com.find.android.core.domain.model.RemoteUserModel
import com.find.android.core.domain.usecase.user.UserUseCase
import com.find.android.core.util.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LanguageViewModel @Inject constructor(
    userUseCase: UserUseCase,
) : BaseViewModel() {

    override val userModel: MutableState<RemoteUserModel> = userUseCase.userModel
    override val friendList: MutableList<RemoteUserModel> = userUseCase.friendList


}