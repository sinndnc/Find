package com.find.android.core.domain.mapper

import com.find.android.core.data.local.room.entity.User
import com.find.android.core.domain.model.UserModel

fun User.toUserModule() = UserModel(
    uid = this.uid,
    name = this.name,
    email = this.email,
    surname = this.surname,
    image = this.image
)

