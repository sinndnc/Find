package com.find.android.feature.presentation.main.profile.model

sealed class ProfileColumnItems(
    val items: List<ProfileRowItems>,
    val name: String,
) {

    object Lists : ProfileColumnItems(lists, "Lists")
    object Preferences : ProfileColumnItems(preferences, "Preferences")
    object Account : ProfileColumnItems(account, "Account")

    companion object {
        val lists = listOf(ProfileRowItems.Favorites, ProfileRowItems.Downloads)
        val preferences = listOf(ProfileRowItems.DarkMode, ProfileRowItems.Notifications)
        val account = listOf(ProfileRowItems.Setting, ProfileRowItems.Billing)
    }
}