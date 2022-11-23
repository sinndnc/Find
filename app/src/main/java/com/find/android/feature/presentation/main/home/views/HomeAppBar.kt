package com.find.android.feature.presentation.main.home.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.SwipeableState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.find.android.R
import com.find.android.feature.presentation.main.home.HomeViewModel
import com.find.android.feature.util.extension.convertToBitmap
import kotlinx.coroutines.launch

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun BoxScope.HomeAppBar(
    viewModel: HomeViewModel,
    appBarSettingState: SwipeableState<AppBarSheetState>,
    appBarProfileState: SwipeableState<AppBarSheetState>
) {

    val scope = rememberCoroutineScope()
    val userModel by remember { viewModel.userModel }
    val bitmap = userModel.image?.convertToBitmap()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .statusBarsPadding()
            .fillMaxWidth(0.1f)
            .align(Alignment.TopCenter),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        bitmap?.let {
            Image(it.asImageBitmap(),
                contentDescription = "avatar",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(45.dp)
                    .clip(CircleShape)
                    .border(1.dp, Color.White, CircleShape)
                    .background(Color.DarkGray)
                    .clickable {
                        scope.launch {
                            viewModel.clickToProfile(appBarProfileState)
                        }
                    })
            Icon(
                Icons.Rounded.Search,
                contentDescription = "message",
                modifier = Modifier
                    .size(45.dp)
                    .clip(CircleShape)
                    .border(1.dp, Color.White, CircleShape)
                    .background(Color.LightGray)
                    .clickable {
                        scope.launch {
                            viewModel.clickToSetting(appBarSettingState)
                        }
                    }
                    .padding(5.dp)
            )
        }
    }
}
