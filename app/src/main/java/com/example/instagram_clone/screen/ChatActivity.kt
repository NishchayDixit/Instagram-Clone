package com.example.instagram_clone.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.instagram_clone.R
import com.example.instagram_clone.data.ChatList
import com.example.instagram_clone.model.Chat

@Composable
fun ChatActivity() {
    val navController = rememberNavController()
    Column(modifier = Modifier.padding(5.dp)) {
        TopBar(userName = "_nishchay_dixit_", navigateUp = {navController.navigateUp()})
        val textState = remember { mutableStateOf(TextFieldValue("")) }
        SearchView(textState)
        ChatCardList(chatList = ChatList().getChatList())
    }
}

@Composable
fun TopBar(
    userName: String,
    navigateUp: () -> Unit,
) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = navigateUp) {
                    Icon(Icons.Default.ArrowBack, contentDescription = null)
                }
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = userName, textAlign = TextAlign.Center, fontSize = 18.sp)
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.ic_baseline_more_horiz_24), contentDescription = null)
            }
        }
    }
}

@Composable
fun SearchView(state: MutableState<TextFieldValue>) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp),
    ) {
        TextField(
            value = state.value,
            onValueChange = { value ->
                state.value = value
            },
            placeholder = { Text(text = "Search", color = MaterialTheme.colors.onBackground) },
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp))
                .background(color = if (isSystemInDarkTheme()) Color.DarkGray else Color.White),
            textStyle = TextStyle(color = Color.Black, fontSize = 18.sp),
            leadingIcon = {
                Icon(
                    Icons.Default.Search,
                    contentDescription = "",
                    modifier = Modifier
                        .padding(15.dp)
                        .size(24.dp)
                )
            },
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                textColor = if (isSystemInDarkTheme()) Color.White else Color.LightGray,
                disabledTextColor = Color.Transparent,
                backgroundColor = if (isSystemInDarkTheme()) Color.DarkGray else Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )
    }
}

@Composable
fun ChatCard(chat: Chat, modifier: Modifier = Modifier) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = chat.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .clip(
                        CircleShape
                    )
                    .size(60.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(20.dp))
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                Column() {
                    Text(
                        text = stringResource(id = chat.userName),
                        fontSize = 16.sp,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Normal
                    )
                    Text(text = stringResource(id = chat.messageTime), color = Color.DarkGray)
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(painter = painterResource(id = R.drawable.ic_outlined_camera), contentDescription = null, modifier = Modifier.size(25.dp))
                }
            }
        }
    }
}

@Composable
fun ChatCardList(chatList: List<Chat>, modifier: Modifier = Modifier) {
    LazyColumn {
        items(chatList) {chat -> ChatCard(chat = chat)}
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppPreview() {
    ChatActivity()
}
