package com.example.instagram_clone.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController

@Composable
fun SearchActivity() {
    val navController = rememberNavController()
    Column(modifier = Modifier.fillMaxSize()) {
        TopSearchBar(navigateUp = { navController.navigateUp() })
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Nothing to Show", textAlign = TextAlign.Center)
        }
    }
}

@Composable
fun TopSearchBar(
    navigateUp: () -> Unit,
) {
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    Box(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = navigateUp) {
                    Icon(Icons.Default.ArrowBack, contentDescription = null)
                }
                Spacer(modifier = Modifier.width(10.dp))
                SearchComponent(state = textState)
            }
        }
    }
}

@Composable
fun SearchComponent(state: MutableState<TextFieldValue>) {
    Row(
        modifier = Modifier
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BarPreview() {
    SearchActivity()
}
