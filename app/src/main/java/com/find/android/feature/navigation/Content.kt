package com.find.android.feature.navigation

sealed class Content(val route: String) {

    object Splash : Content("splash")
    object OnBoard : Content("onBoard")
    object SignUp : Content("register")
    object Login : Content("login")
    object Home : Content("home")
    object Notification : Content("notifications")
    object Language : Content("language")
    object Privacy : Content("privacy")
    object NotFound : Content("not_found")

    companion object {
        const val AUTH_GRAPH = "auth_graph"
        const val MAIN_GRAPH = "home_graph"
    }
}


