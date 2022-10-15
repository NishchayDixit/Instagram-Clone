package com.example.instagram_clone.navigation

sealed class Screen(val route: String) {
    object Splash: Screen("splash_screen")
    object Home: Screen("home_screen")
    object Chat: Screen("chat_screen")
    object Story: Screen("story_screen")
}
