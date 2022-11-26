package com.find.android.feature.presentation.main.notification.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun NotificationAppBar(navController: NavController) {

    val typography = MaterialTheme.typography
    val shape = MaterialTheme.shapes

    Row(
        modifier = Modifier
            .statusBarsPadding()
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Icon(
            Icons.Rounded.ArrowBack, modifier = Modifier
                .size(27.dp)
                .clip(shape.medium)
                .clickable {
                    navController.popBackStack()
                }, contentDescription = "arrowBack"
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text("Notifications", style = typography.h6)
        Spacer(modifier = Modifier.weight(1f))
        Switch(checked = true, onCheckedChange = {})
    }
}