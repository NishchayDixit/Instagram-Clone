package com.example.instagram_clone.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagram_clone.R

@Composable
fun StoryActivity() {
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    Box(modifier = Modifier
        .fillMaxSize()
    ) {
        Image(painter = painterResource(id = R.drawable.profile_10), contentDescription = null, contentScale = ContentScale.FillWidth, modifier = Modifier.size(1200.dp))

        Column(modifier = Modifier.fillMaxWidth()) {
            StoryScreen()
            Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Bottom) {
                SendView(state = textState)
            }
        }
    }
}

@Composable
fun StoryScreen() {
    Box(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile_10),
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
                Row(horizontalArrangement = Arrangement.Center) {
                    Text(
                        text = stringResource(id = R.string.userName_10),
                        fontSize = 16.sp,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Normal
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "2m", color = Color.DarkGray, fontSize = 16.sp,)
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(painter = painterResource(id = R.drawable.ic_baseline_more_vert_24), contentDescription = null, modifier = Modifier.size(25.dp))
                }
            }
        }
    }
}

@Composable
fun SendView(state: MutableState<TextFieldValue>) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp),
    ) {
        TextField(
            value = state.value,
            onValueChange = { value ->
                state.value = value
            },
            placeholder = { Text(text = "Send Message", color = MaterialTheme.colors.onBackground) },
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp))
                .background(color = if (isSystemInDarkTheme()) Color.DarkGray else Color.White),
            textStyle = TextStyle(color = Color.Black, fontSize = 18.sp),
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                textColor = if (isSystemInDarkTheme()) Color.White else Color.LightGray,
                disabledTextColor = Color.Transparent,
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )
    }
}
