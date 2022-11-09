package com.find.android.feature.presentation.main.profile.model.profile

import com.find.android.R

sealed class ProfileRowItems(
    val name: String,
    val icon: Int,
    val type: ProfileRowItemEnum,
) {
    object Language : ProfileRowItems("Language", R.drawable.language, ProfileRowItemEnum.TextArrowRight)
    object DarkMode : ProfileRowItems("Dark mode", R.drawable.dark_mode, ProfileRowItemEnum.Switch)
    object Notifications : ProfileRowItems("Notifications", R.drawable.notifications, ProfileRowItemEnum.ArrowRight)

    object Privacy : ProfileRowItems("Privacy", R.drawable.privacy, ProfileRowItemEnum.ArrowRight)
    object TermsAndPolicy : ProfileRowItems("Terms & Policy", R.drawable.terms, ProfileRowItemEnum.ArrowRight)
    object Account : ProfileRowItems("Account Information", R.drawable.account, ProfileRowItemEnum.ArrowRight)

}
