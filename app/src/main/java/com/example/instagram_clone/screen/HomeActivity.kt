package com.example.instagram_clone.screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.instagram_clone.R
import com.example.instagram_clone.data.PostList
import com.example.instagram_clone.model.Post
import com.example.instagram_clone.model.User
import com.example.instagram_clone.navigation.Screen

@Composable
fun HomeActivity() {
    Box {
        Column {
            Column {
                PostComponent(postList = PostList().getPostList())
            }
        }
    }
}

@Composable
fun HeaderComponent(
    onMessageClick: () -> Unit
) {
    TopAppBar(
        title = {
            Image(
                painter = painterResource(id = if (isSystemInDarkTheme()) R.drawable.instagram_text else R.drawable.instagram_text_black),
                contentDescription = "App Text Logo",
                modifier = Modifier.size(110.dp)
            )
        },
        backgroundColor = if (isSystemInDarkTheme()) Color.Black else Color.White,
        elevation = 2.dp,
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_outlined_add),
                    contentDescription = "Add Post",
                    modifier = Modifier.size(25.dp),
                    tint = if (isSystemInDarkTheme()) Color.White else Color.Black
                )
            }
            IconButton(onClick = onMessageClick) {
                Icon(
                    painter = painterResource(id = R.drawable.messenger_mono),
                    contentDescription = "Send Message",
                    modifier = Modifier.size(25.dp),
                    tint = if (isSystemInDarkTheme()) Color.White else Color.Black
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    StoryComponent(
        User(painterResource(id = R.drawable.profile_1), stringResource(id = R.string.userName_1))
    )
}

@Composable
fun StoryComponent(user: User) {
    Box(
        modifier = Modifier.padding(10.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Canvas(
            modifier = Modifier.size(80.dp)
        ) {
            val instaColors = listOf(Color.Yellow, Color.Red, Color.Magenta)
            drawCircle(
                brush = Brush.linearGradient(instaColors),
                style = Stroke(width = 15f, cap = StrokeCap.Round)
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape),
                painter = user.profilePic,
                contentDescription = "Story",
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = user.username,
                color = if (isSystemInDarkTheme()) Color.White else Color.DarkGray,
                fontWeight = FontWeight.Normal,
                fontSize = 13.sp
            )
        }
    }
}

@Composable
fun PostComponent(
    postList: List<Post>,
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()
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

    Scaffold(
        topBar = {
            HeaderComponent(
                onMessageClick = { }
            )
        },
        backgroundColor = if (isSystemInDarkTheme()) Color.Black else Color.White,
        bottomBar = { BottomAppNavigation() }
    ) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            item {
                LazyRow {
                    items(users) { user ->
                        StoryComponent(user)
                    }
                }
            }
            item { Divider() }
            items(postList) { post ->
                PostCard(post = post)
            }
        }
    }
}

@Composable
fun PostCard(post: Post, modifier: Modifier = Modifier) {

    var fav by remember { mutableStateOf(false) }
    var save by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = post.profile),
                    contentDescription = "User Profile",
                    modifier = Modifier
                        .clip(
                            CircleShape
                        )
                        .size(35.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(10.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(verticalArrangement = Arrangement.Center) {
                        Text(
                            text = stringResource(id = post.userName),
                            fontWeight = FontWeight.Normal,
                            fontSize = 18.sp
                        )
                    }
                    Column {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_more_vert_24),
                            contentDescription = "more"
                        )
                    }
                }
            }
            Image(
                painter = painterResource(id = post.postImage),
                contentDescription = "Post Pic",
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
//                    Image(
//                        painter = painterResource(id = R.drawable.like),
//                        contentDescription = "Like",
//                        modifier = Modifier.size(25.dp)
//                    )
                    IconToggleButton(checked = fav, onCheckedChange = { fav = it }) {
                        val icon = if (fav) R.drawable.like else R.drawable.like_black
                        val tint =
                            if (fav) Color(224, 45, 45, 255) else MaterialTheme.colors.onBackground
                        Icon(
                            painter = painterResource(id = icon),
                            contentDescription = "Like",
                            tint = tint,
                            modifier = Modifier.size(25.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(5.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_outlined_comment),
                        contentDescription = "Comment",
                        modifier = Modifier.size(25.dp),
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_dm),
                        contentDescription = "share",
                        modifier = Modifier.size(25.dp),
                    )
                }
                IconToggleButton(checked = save, onCheckedChange = { save = it }) {
                    val icon =
                        if (save) R.drawable.ic_filled_bookmark else R.drawable.ic_outlined_bookmark
                    val tint =
                        if (save) MaterialTheme.colors.onBackground else MaterialTheme.colors.onBackground
                    Icon(
                        painter = painterResource(id = icon),
                        contentDescription = "save",
                        tint = tint,
                        modifier = Modifier.size(25.dp)
                    )
                }
//                Icon(
//                    painter = painterResource(id = R.drawable.save),
//                    contentDescription = "save",
//                    modifier = Modifier.size(36.dp),
//                )
            }
            Column(
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .fillMaxWidth()
            ) {
                Text(text = stringResource(id = post.likesCount), fontWeight = FontWeight.Medium)
                Text(
                    text = buildAnnotatedString {
                        append(
                            AnnotatedString(
                                text = stringResource(id = post.userName),
                                spanStyle = SpanStyle(fontWeight = FontWeight.Medium)
                            )
                        )
                        append(text = " ")
                        append(text = stringResource(id = post.postDescription))
                    }
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = stringResource(id = post.commentCount),
                    color = Color.DarkGray,
                    fontSize = 13.sp,
                    modifier = Modifier.padding(bottom = 13.dp)
                )
            }
        }
    }
}

@Composable
fun BottomAppNavigation() {
    BottomAppBar(
        modifier = Modifier.padding(bottom = 15.dp),
        backgroundColor = if (isSystemInDarkTheme()) Color.Black else Color.White
    ) {
        BottomNavigationItem(
            selected = true,
            onClick = {},
            icon = {
                Icon(
                    painter = painterResource(R.drawable.ic_filled_home),
                    contentDescription = "Home Icon",
                    modifier = Modifier.size(28.dp),
                )
            }
        )
        BottomNavigationItem(
            selected = false,
            onClick = { },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.ic_outlined_search),
                    contentDescription = "Search Icon",
                    modifier = Modifier.size(28.dp),
                    tint = if (isSystemInDarkTheme()) Color.White else Color.Black
                )
            }
        )
        BottomNavigationItem(
            selected = false,
            onClick = { },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.ic_outlined_reels),
                    contentDescription = "Reels Icon",
                    modifier = Modifier.size(28.dp),
                    tint = if (isSystemInDarkTheme()) Color.White else Color.Black
                )
            }
        )
        BottomNavigationItem(
            selected = false,
            onClick = { },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.like_black),
                    contentDescription = "Like Icon",
                    modifier = Modifier.size(28.dp),
                    tint = if (isSystemInDarkTheme()) Color.White else Color.Black
                )
            }
        )
        BottomNavigationItem(
            selected = false,
            onClick = { },
            icon = {
                Image(
                    painter = painterResource(R.drawable.madara),
                    contentDescription = "Profile Icon",
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }
        )
    }
}
