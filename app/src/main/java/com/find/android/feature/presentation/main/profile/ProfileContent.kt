package com.find.android.feature.presentation.main.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.find.android.feature.presentation.main.home.views.AppBarSheetState
import com.find.android.feature.presentation.main.profile.component.ProfileImageSetting
import com.find.android.feature.presentation.main.profile.component.ProfileListsRow
import com.find.android.feature.presentation.main.profile.views.ProfileAppBar

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun ProfileContent(viewModel: ProfileViewModel, navController: NavController, state: SwipeableState<AppBarSheetState>) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ProfileAppBar(viewModel, state)
        Spacer(Modifier.height(30.dp))
        ProfileImageSetting(viewModel )
        ProfileListsRow(viewModel, navController)
    }
}