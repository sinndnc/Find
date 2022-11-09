package com.find.android.feature.presentation.main.profile.model

import com.find.android.R

sealed class ProfileRowItems(
    val name: String,
    val icon: Int,
) {
    object Language : ProfileRowItems("Language", R.drawable.language)
    object DarkMode : ProfileRowItems("Dark mode", R.drawable.dark_mode)
    object Notifications : ProfileRowItems("Notifications",R.drawable.notifications)

    object Privacy : ProfileRowItems("Privacy",R.drawable.policy)

}
