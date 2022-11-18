package com.find.android.core.domain.mapper

import com.find.android.core.data.local.room.entity.LocalUserModel
import com.find.android.core.domain.model.RemoteUserModel
import com.find.android.feature.util.extension.toGeoPoint
import com.find.android.feature.util.extension.toLocationModel

fun LocalUserModel.toRemoteUserModel() = RemoteUserModel(
    uid = uid,
    name = name,
    email = email,
    image = image,
    token = token,
    surname = surname,
    friends = friends,
    activityType = activityType,
    location = location.toGeoPoint(),
)


fun RemoteUserModel.toLocalUserModel() = LocalUserModel(
    uid = uid,
    name = name,
    email = email,
    image = image,
    token = token,
    surname = surname,
    friends = friends,
    activityType = activityType,
    location = location.toLocationModel(),
)
