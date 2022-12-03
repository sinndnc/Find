package com.find.android.feature.presentation.main.home

import android.app.Activity
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.find.android.core.domain.model.RemoteUserModel
import android.content.IntentSender
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.IntentSenderRequest
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.SwipeableState
import com.find.android.core.domain.usecase.location.setting.LocationSettingUseCase
import com.find.android.core.domain.usecase.user.UserUseCase
import com.find.android.core.util.base.BaseViewModel
import com.find.android.feature.presentation.main.home.views.AppBarSheetState
import com.google.android.gms.common.api.ResolvableApiException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
@OptIn(ExperimentalMaterialApi::class)
class HomeViewModel @Inject constructor(
    val userUseCase: UserUseCase,
    private val locationSettingUseCase: LocationSettingUseCase,
) : BaseViewModel() {

    private val _userModel: MutableState<RemoteUserModel> = userUseCase.userModel
    override val userModel: MutableState<RemoteUserModel> = _userModel

    private var _friendList: SnapshotStateList<RemoteUserModel> = userUseCase.friendList
    override var friendList: SnapshotStateList<RemoteUserModel> = _friendList

    suspend fun clickToProfile(state: SwipeableState<AppBarSheetState>) {
        state.snapTo(AppBarSheetState.Profile)
    }

    suspend fun clickToSetting(state: SwipeableState<AppBarSheetState>) {
        state.animateTo(AppBarSheetState.Setting)
    }

    fun checkLocationIsEnabled(resultLauncher: ActivityResultLauncher<IntentSenderRequest>, activity: Activity) {
        locationSettingUseCase.checkLocationIsEnabled().onEach { result ->
            result.onSuccess {
                startLocationService(activity)
            }.onError { exception ->
                if (exception is ResolvableApiException) {
                    try {
                        val intentSenderRequest = IntentSenderRequest.Builder(exception.resolution).build()
                        resultLauncher.launch(intentSenderRequest)
                    } catch (_: IntentSender.SendIntentException) {

                    }
                }
            }
        }.launchIn(CoroutineScope(Dispatchers.IO))
    }


}

