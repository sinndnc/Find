package com.find.android.feature.presentation.main.profile.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.find.android.feature.presentation.main.profile.PersistenceImageSheetState
import com.find.android.feature.presentation.main.profile.ProfileViewModel
import com.find.android.feature.util.extension.convertToBitmap

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun ProfileImageSetting(viewModel: ProfileViewModel, imageState: SwipeableState<PersistenceImageSheetState>) {

    val typography = MaterialTheme.typography
    val userModel by remember { viewModel.userInfo }
    val image = userModel.image?.convertToBitmap()
    val name = userModel.name

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        Box {
            image?.let {
                Image(
                    it.asImageBitmap(),
                    contentDescription = "avatar",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .background(Color.LightGray)
                )
            }
        }
        Column(
            modifier = Modifier.fillMaxWidth(0.8f)
        ) {
            name?.let { Text(it, style = typography.h6, fontWeight = FontWeight.SemiBold) }
            Text("Senior Developer", style = typography.caption, fontWeight = FontWeight.Medium, color = Color.Gray)
        }
    }

}