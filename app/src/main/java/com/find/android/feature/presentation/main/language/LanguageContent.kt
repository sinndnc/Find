package com.find.android.feature.presentation.main.language

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.find.android.feature.presentation.main.language.view.LanguageAppBar

@Composable
fun LanguageContent(
    languageViewModel: LanguageViewModel,
    navController: NavController,
) {
    Column() {
        LanguageAppBar(navController)
    }
}