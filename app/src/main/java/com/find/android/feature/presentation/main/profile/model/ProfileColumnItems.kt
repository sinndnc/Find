package com.find.android.feature.presentation.main.profile.model

sealed class ProfileColumnItems(
    val items: List<ProfileRowItems>,
    val name: String,
) {

    object Preferences : ProfileColumnItems(preferences, "Preferences")
    object Privacy : ProfileColumnItems(privacy, "Privacy and Security")

    companion object {
        val preferences = listOf(ProfileRowItems.Language, ProfileRowItems.DarkMode, ProfileRowItems.Notifications)
        val privacy = listOf(ProfileRowItems.Privacy)
    }
}