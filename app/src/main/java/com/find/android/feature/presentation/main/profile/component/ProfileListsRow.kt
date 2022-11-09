package com.find.android.feature.presentation.main.profile.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.find.android.core.util.theme.ThemeState
import com.find.android.feature.presentation.main.profile.ProfileViewModel
import com.find.android.feature.presentation.main.profile.model.ProfileColumnItems
import com.find.android.feature.presentation.main.profile.model.ProfileRowItems
import kotlinx.coroutines.launch

@Composable
fun ProfileListsRow(viewModel: ProfileViewModel) {

    val theme = viewModel.themeSetting.themeState.collectAsState()
    val categoryList = listOf(ProfileColumnItems.Preferences,ProfileColumnItems.Privacy)
    val openDialog = viewModel.openDialog

    if (openDialog.value) CustomDialog(openDialog)

    Column(
        modifier = Modifier.padding(20.dp), verticalArrangement = Arrangement.SpaceAround, horizontalAlignment = Alignment.Start
    ) {
        Text(text = ProfileColumnItems.Preferences.name, color = Color.Gray)
        ProfileItemRow(
            ProfileRowItems.Language.name, ProfileRowItems.Language.icon, icon = {
                Row {
                    Text(text = "Türkçe")
                    Spacer(modifier = Modifier.width(5.dp))
                    Icon(Icons.Rounded.KeyboardArrowRight, contentDescription = "arrow")
                }
            }, enabled = true
        ) {
            openDialog.value = true
        }
        Spacer(Modifier.height(10.dp))
        ProfileItemRow(ProfileRowItems.DarkMode.name, ProfileRowItems.DarkMode.icon, icon = {
            Switch(
                checked = theme.value == ThemeState.Dark, onCheckedChange = {
                        viewModel.toggleTheme()
                }, colors = SwitchDefaults.colors(
                    uncheckedThumbColor = Color.DarkGray,
                    uncheckedTrackColor = Color.Gray,
                )
            )
        })
    }
}


@Composable
fun CustomDialog(openDialog: MutableState<Boolean>) {

    val configuration = LocalConfiguration.current
    val height = configuration.screenHeightDp.dp
    val width = configuration.screenWidthDp.dp

    Dialog(
        onDismissRequest = {
            openDialog.value = false
        }
    ) {
        Column(
            modifier = Modifier
                .background(Color.Black, MaterialTheme.shapes.large)
                .padding(10.dp)
                .height(height * 0.4f)
                .width(width * 0.75f)
                .verticalScroll(rememberScrollState())
        ) {
            repeat(20) {
                Text("Item $it", modifier = Modifier.padding(2.dp), color = Color.LightGray)
            }
        }
    }
}