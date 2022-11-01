package com.find.android.feature.presentation.main.setting

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.find.android.feature.presentation.main.home.views.AppBarSheetState
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SettingsContent(viewModel: SettingsViewModel, navController: NavController, state: SwipeableState<AppBarSheetState>) {

    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
        contentAlignment = Alignment.Center
    ) {
        IconButton(
            onClick = {
                scope.launch {
                    state.animateTo(AppBarSheetState.Collapsed)
                }
            }, modifier = Modifier.align(Alignment.TopStart)
        ) {
            Icon(Icons.Rounded.KeyboardArrowDown, contentDescription = "back")
        }
        Text(text = "Setting Page")
    }
}