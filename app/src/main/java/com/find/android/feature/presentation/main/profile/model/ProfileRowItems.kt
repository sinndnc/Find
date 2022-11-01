package com.find.android.feature.presentation.main.profile.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ProfileRowItems(
    val name: String,
    val icon: ImageVector,
) {
    object Notifications : ProfileRowItems("Notifications", Icons.Rounded.Notifications)
    object DarkMode : ProfileRowItems("Dark mode", Icons.Rounded.LocationOn)
    object Favorites : ProfileRowItems("Favorites", Icons.Rounded.FavoriteBorder)
    object Downloads : ProfileRowItems("Downloads", Icons.Rounded.ExitToApp)
    object Billing : ProfileRowItems("Billing", Icons.Rounded.AccountBox)
    object Setting : ProfileRowItems("Setting", Icons.Rounded.Settings)


}
