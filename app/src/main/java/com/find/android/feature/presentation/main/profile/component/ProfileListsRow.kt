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
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.find.android.core.util.theme.ThemeState
import com.find.android.feature.presentation.main.profile.ProfileViewModel
import com.find.android.feature.presentation.main.profile.model.profile.ProfileColumnItems
import com.find.android.feature.presentation.main.profile.model.profile.ProfileRowItemEnum
import kotlinx.coroutines.launch

@Composable
fun ProfileListsRow(viewModel: ProfileViewModel, navController: NavController) {

    val coroutineScope = rememberCoroutineScope()
    val theme = viewModel.themeSetting.themeState.collectAsState()
    val categories = listOf(ProfileColumnItems.Preferences, ProfileColumnItems.Privacy)

    for (category in categories) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = category.name, color = Color.Gray)
            Spacer(Modifier.height(5.dp))
            for (item in category.items) {
                ProfileItemRow(
                    item.name,
                    item.icon,
                    enabled = item.type != ProfileRowItemEnum.Switch,
                    icon = {
                        if (item.type == ProfileRowItemEnum.Switch)
                            Switch(checked = theme.value == ThemeState.Dark, onCheckedChange = {
                                viewModel.toggleTheme()
                            })
                        else
                            Row {
                                Text(text = if (item.type == ProfileRowItemEnum.TextArrowRight) item.name else "")
                                Icon(Icons.Rounded.KeyboardArrowRight, contentDescription = "arrow")
                            }
                    }
                ) {
                    coroutineScope.launch{
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                inclusive = true
                                saveState = true
                            }
                            launchSingleTop = true
                        }
                    }
                }
                Spacer(Modifier.height(10.dp))
            }
        }
    }
}