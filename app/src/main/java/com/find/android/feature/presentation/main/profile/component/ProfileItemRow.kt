package com.find.android.feature.presentation.main.profile.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ProfileItemRow(
    name: String,
    leadIcon: Int,
    icon: @Composable () -> Unit,
    enabled: Boolean = true,
    onClick: () -> Unit = {}
) {

    val configuration = LocalConfiguration.current
    val height = configuration.screenHeightDp.dp

    Row(
        modifier = Modifier
            .clip( MaterialTheme.shapes.medium)
            .background(Color.LightGray.copy(0.25f),)
            .height(height * 0.055f)
            .clickable {
                if (enabled) onClick()
            }
            .padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(painterResource(leadIcon), contentDescription = null)
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = name, modifier = Modifier.weight(1f))
        icon()
    }
}