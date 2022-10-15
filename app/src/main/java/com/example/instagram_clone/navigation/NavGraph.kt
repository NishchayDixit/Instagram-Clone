package com.example.instagram_clone.navigation

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.instagram_clone.R
import com.example.instagram_clone.model.User
import com.example.instagram_clone.screen.*

@Composable
fun SetupNavGraph(navHostController: NavHostController) {
    val users = listOf(
        User(
            painterResource(id = R.drawable.profile_1),
            stringResource(id = R.string.userName_1)
        ),
        User(
            painterResource(id = R.drawable.profile_2),
            stringResource(id = R.string.userName_2)
        ),
        User(
            painterResource(id = R.drawable.profile_3),
            stringResource(id = R.string.userName_3)
        ),
        User(
            painterResource(id = R.drawable.profile_4),
            stringResource(id = R.string.userName_4)
        ),
        User(
            painterResource(id = R.drawable.profile_5),
            stringResource(id = R.string.userName_5)
        ),
        User(
            painterResource(id = R.drawable.profile_6),
            stringResource(id = R.string.userName_6)
        ),
        User(
            painterResource(id = R.drawable.profile_7),
            stringResource(id = R.string.userName_7)
        ),
        User(
            painterResource(id = R.drawable.profile_8),
            stringResource(id = R.string.userName_8)
        ),
        User(
            painterResource(id = R.drawable.profile_9),
            stringResource(id = R.string.userName_9)
        ),
        User(
            painterResource(id = R.drawable.profile_10),
            stringResource(id = R.string.userName_10)
        ),
    )
    NavHost(navController = navHostController, startDestination = Screen.Splash.route) {
        composable(route = Screen.Splash.route) {
            SplashAActivity(navHostController)
        }

        composable(route = Screen.Home.route) {
            HomeActivity()
            HeaderComponent(onMessageClick = {
                navHostController.navigate(Screen.Chat.route)
            }, onSearchClicked = {
                navHostController.navigate(Screen.Search.route)
            })
        }

        composable(route = Screen.Chat.route) {
            ChatActivity()
        }

        composable(route = Screen.Story.route) {
            StoryActivity()
        }

        composable(route = Screen.Search.route) {
            SearchActivity()
        }
    }
}