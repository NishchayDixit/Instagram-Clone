package com.example.instagram_clone.data

import com.example.instagram_clone.R
import com.example.instagram_clone.model.Chat


class ChatList {
    fun getChatList(): List<Chat> {
        return listOf(
            Chat(R.drawable.profile_1, R.string.userName_1, R.string.time_1),
            Chat(R.drawable.profile_2, R.string.userName_2, R.string.time_2),
            Chat(R.drawable.profile_3, R.string.userName_3, R.string.time_3),
            Chat(R.drawable.profile_4, R.string.userName_4, R.string.time_4),
            Chat(R.drawable.profile_5, R.string.userName_5, R.string.time_5),
            Chat(R.drawable.profile_6, R.string.userName_6, R.string.time_6),
            Chat(R.drawable.profile_7, R.string.userName_7, R.string.time_7),
            Chat(R.drawable.profile_8, R.string.userName_8, R.string.time_8),
            Chat(R.drawable.profile_9, R.string.userName_9, R.string.time_9),
            Chat(R.drawable.profile_10, R.string.userName_10, R.string.time_10),
        )
    }
}