package com.example.instagram_clone.data

import com.example.instagram_clone.R
import com.example.instagram_clone.model.Post

class PostList {
    fun getPostList(): List<Post>{
        return listOf<Post>(
            Post(R.drawable.profile_1, R.string.userName_1, R.drawable.post_1, R.string.likesCount_1, R.string.postDescription_1, R.string.commentCount_1),
            Post(R.drawable.profile_8, R.string.userName_8, R.drawable.post_8, R.string.likesCount_8, R.string.postDescription_8, R.string.commentCount_8),
            Post(R.drawable.profile_3, R.string.userName_3, R.drawable.post_3, R.string.likesCount_3, R.string.postDescription_3, R.string.commentCount_3),
            Post(R.drawable.profile_4, R.string.userName_4, R.drawable.post_4, R.string.likesCount_4, R.string.postDescription_4, R.string.commentCount_4),
            Post(R.drawable.profile_5, R.string.userName_5, R.drawable.post_5, R.string.likesCount_5, R.string.postDescription_5, R.string.commentCount_5),
            Post(R.drawable.profile_2, R.string.userName_2, R.drawable.post_2, R.string.likesCount_2, R.string.postDescription_2, R.string.commentCount_2),
            Post(R.drawable.profile_10, R.string.userName_10, R.drawable.post_10, R.string.likesCount_10, R.string.postDescription_10, R.string.commentCount_10),
            Post(R.drawable.profile_9, R.string.userName_9, R.drawable.post_9, R.string.likesCount_9, R.string.postDescription_9, R.string.commentCount_9),
            Post(R.drawable.profile_6, R.string.userName_6, R.drawable.post_6, R.string.likesCount_6, R.string.postDescription_6, R.string.commentCount_6),
            Post(R.drawable.profile_7, R.string.userName_7, R.drawable.post_7, R.string.likesCount_7, R.string.postDescription_7, R.string.commentCount_7)
        )
    }
}