package com.find.android.core.domain.usecase.location.setting

import com.find.android.core.util.event.ResponseState
import kotlinx.coroutines.flow.Flow

interface LocationSettingHelper {

    fun checkLocationIsEnabled(): Flow<ResponseState<Boolean?>>
}