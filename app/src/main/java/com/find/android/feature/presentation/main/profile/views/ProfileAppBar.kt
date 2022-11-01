package com.find.android.feature.presentation.main.profile.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.find.android.feature.presentation.main.home.views.AppBarSheetState
import com.find.android.feature.presentation.main.profile.ProfileViewModel
import kotlinx.coroutines.launch

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun ProfileAppBar(viewModel: ProfileViewModel, state: SwipeableState<AppBarSheetState>) {

    val coroutineScope = rememberCoroutineScope()

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(
            onClick = {
                coroutineScope.launch{
                    viewModel.backToHomeContent(state)
                }
            }
        ) {
            Icon(Icons.Rounded.KeyboardArrowDown, contentDescription = "back")
        }
        Text(text = "My Profile", fontWeight = FontWeight.Medium)
        IconButton(
            onClick = {}
        ) {
            Icon(Icons.Rounded.MoreVert, contentDescription = "MoreVert")
        }
    }
}