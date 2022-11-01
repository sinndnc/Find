package com.find.android.feature.component.dot

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun PointDot(modifier: Modifier = Modifier, color: Color =  MaterialTheme.colors.primary, size: Dp = 5.dp) {
    Box(modifier.size(size).background(color, RoundedCornerShape(20.dp)))
}