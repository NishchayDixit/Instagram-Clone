package com.example.instagram_clone.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.instagram_clone.screen.ChatActivity
import com.example.instagram_clone.screen.HomeActivity
import com.example.instagram_clone.screen.SplashAActivity
import com.example.instagram_clone.screen.StoryActivity

@Composable
fun SetupNavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Screen.Splash.route) {
        composable(route = Screen.Splash.route) {
            SplashAActivity(navHostController)
        }

        composable(route = Screen.Home.route) {
            HomeActivity()
        }

        composable(route = Screen.Chat.route) {
            ChatActivity()
        }

        composable(route = Screen.Story.route) {
            StoryActivity()
        }
    }
}