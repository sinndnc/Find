package com.find.android.feature.util.event

import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver

@Composable
fun LifeCycleEvent(
    onCreate:() -> Unit = {},
    onStart: () -> Unit = {},
    onResume: () -> Unit = {},
    onPause: () -> Unit = {},
    onStop: () -> Unit = {},
    onDestroy: () -> Unit = {},
    onAny: () -> Unit = {},
) {

    val lifecycleOwner = LocalLifecycleOwner.current
    val currentOnAny by rememberUpdatedState(onAny)
    val currentOnCreate by rememberUpdatedState(onCreate)
    val currentOnStart by rememberUpdatedState(onStart)
    val currentOnResume by rememberUpdatedState(onResume)
    val currentOnPause by rememberUpdatedState(onPause)
    val currentOnStop by rememberUpdatedState(onStop)
    val currentOnDestroy by rememberUpdatedState(onDestroy)

    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_CREATE -> currentOnCreate()
                Lifecycle.Event.ON_START -> currentOnStart()
                Lifecycle.Event.ON_RESUME -> currentOnResume()
                Lifecycle.Event.ON_PAUSE -> currentOnPause()
                Lifecycle.Event.ON_STOP -> currentOnStop()
                Lifecycle.Event.ON_DESTROY -> currentOnDestroy()
                Lifecycle.Event.ON_ANY -> currentOnAny()
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
}

