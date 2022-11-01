package com.find.android.core.util.extension

import com.find.android.core.util.annotation.GoogleApi
import com.google.android.gms.common.ConnectionResult

@GoogleApi
fun Int.checkIsAvailable(): Boolean = this == ConnectionResult.SUCCESS
