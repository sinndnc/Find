package com.find.android.feature.presentation.main.profile.model.profile

import com.find.android.R

sealed class ProfileRowItems(
    val name: String,
    val route: String,
    val icon: Int,
    val type: ProfileRowItemEnum,
) {
    object Language : ProfileRowItems("Language", "language", R.drawable.language, ProfileRowItemEnum.TextArrowRight)
    object DarkMode : ProfileRowItems("Dark mode", "darkMode", R.drawable.dark_mode, ProfileRowItemEnum.Switch)
    object Notifications : ProfileRowItems("Notifications", "notifications", R.drawable.notifications, ProfileRowItemEnum.ArrowRight)

    object Privacy : ProfileRowItems("Privacy", "privacy", R.drawable.privacy, ProfileRowItemEnum.ArrowRight)
    object TermsAndPolicy : ProfileRowItems("Terms & Policy", "terms", R.drawable.terms, ProfileRowItemEnum.ArrowRight)
    object Account : ProfileRowItems("Account Information", "account", R.drawable.account, ProfileRowItemEnum.ArrowRight)

}
