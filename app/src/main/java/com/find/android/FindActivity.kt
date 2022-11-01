package com.find.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.core.view.WindowCompat
import com.find.android.core.util.notification.NotificationHelper
import com.find.android.core.util.theme.ThemeSetting
import com.find.android.feature.component.theme.FindTheme
import com.find.android.feature.navigation.FindNavigationGraph
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FindActivity : ComponentActivity() {

    @Inject
    lateinit var themeSetting: ThemeSetting

    @Inject
    lateinit var notificationHelper: NotificationHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeContent()
    }

    private fun initializeContent() {
        initializeSettings()
        setContent {
            val theme = themeSetting.themeState.collectAsState()
            FindTheme(theme.value) {
                FindNavigationGraph()
            }
        }
    }

    private fun initializeSettings() {
        notificationHelper.createChatNotificationChannel()
        WindowCompat.setDecorFitsSystemWindows(window, false)
    }

}
