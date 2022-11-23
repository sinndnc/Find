package com.find.android.core.domain.usecase.user

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.find.android.core.domain.model.RemoteUserModel

interface UserUseCase {

    val userModel: MutableState<RemoteUserModel>

    val friendList: SnapshotStateList<RemoteUserModel>

    fun getUserInformation()

}