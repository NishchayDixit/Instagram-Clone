package com.example.instagram_clone.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.instagram_clone.R
import com.example.instagram_clone.navigation.Screen
import kotlinx.coroutines.delay

@Composable
fun SplashAActivity(navController: NavController) {
    LaunchedEffect(key1 = true) {
        delay(1500)
        navController.navigate(Screen.Home.route) {
            popUpTo(0)
        }
    }
    Splash()
}

@Composable
fun Splash() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(
                if (isSystemInDarkTheme()) {
                    Color.Black
                } else {
                    Color.White
                }
            )
    ) {
        Image(
            painter = painterResource(id = R.drawable.instagram_logo),
            contentDescription = "App Logo"
        )
    }
}