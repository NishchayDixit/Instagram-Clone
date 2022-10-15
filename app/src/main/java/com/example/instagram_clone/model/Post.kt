package com.example.instagram_clone.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Post(
    @DrawableRes val profile: Int,
    @StringRes val userName: Int,
    @DrawableRes val postImage: Int,
    @StringRes val likesCount: Int,
    @StringRes val postDescription: Int,
    @StringRes val commentCount: Int,
)
