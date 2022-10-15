package com.example.instagram_clone.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Chat(
    @DrawableRes val imageRes: Int,
    @StringRes val userName: Int,
    @StringRes val messageTime: Int,
)
