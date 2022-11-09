package com.find.android.feature.presentation.main.profile.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.find.android.core.util.theme.ThemeState
import com.find.android.feature.presentation.main.profile.ProfileViewModel
import com.find.android.feature.presentation.main.profile.model.profile.ProfileColumnItems
import com.find.android.feature.presentation.main.profile.model.profile.ProfileRowItemEnum

@Composable
fun ProfileListsRow(viewModel: ProfileViewModel) {

    val theme = viewModel.themeSetting.themeState.collectAsState()
    val categories = listOf(ProfileColumnItems.Preferences, ProfileColumnItems.Privacy)
    val openDialog = viewModel.openDialog

    if (openDialog.value) CustomDialog(openDialog)

    for (category in categories) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = category.name, color = Color.Gray)
            Spacer(Modifier.height(5.dp))
            for (item in category.items) {
                when (item.type) {
                    ProfileRowItemEnum.Switch -> {
                        ProfileItemRow(
                            item.name,
                            item.icon,
                            icon = {
                                Switch(
                                    checked = theme.value == ThemeState.Dark, onCheckedChange = {
                                        viewModel.toggleTheme()
                                    }, colors = SwitchDefaults.colors(
                                        uncheckedThumbColor = Color.DarkGray,
                                        uncheckedTrackColor = Color.Gray,
                                    )
                                )
                            }
                        )
                    }
                    ProfileRowItemEnum.ArrowRight -> {
                        ProfileItemRow(
                            item.name,
                            item.icon,
                            icon = {
                                Row {
                                    Icon(Icons.Rounded.KeyboardArrowRight, contentDescription = "arrow")
                                }
                            }
                        )
                    }
                    ProfileRowItemEnum.TextArrowRight -> {
                        ProfileItemRow(
                            item.name,
                            item.icon,
                            icon = {
                                Row {
                                    Text(text = "Türkçe")
                                    Spacer(modifier = Modifier.width(5.dp))
                                    Icon(Icons.Rounded.KeyboardArrowRight, contentDescription = "arrow")
                                }
                            }, enabled = true
                        ) {
                            openDialog.value = true
                        }
                    }
                }
                Spacer(Modifier.height(10.dp))
            }
        }
    }
}