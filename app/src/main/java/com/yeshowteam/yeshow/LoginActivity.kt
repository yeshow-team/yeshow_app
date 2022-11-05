package com.yeshowteam.yeshow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Restaurant
import androidx.compose.material.icons.rounded.Search
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.yeshowteam.yeshow.ui.theme.PrimaryColor
import com.yeshowteam.yeshow.ui.theme.TextColor
import com.yeshowteam.yeshow.ui.theme.TextSub
import com.yeshowteam.yeshow.ui.theme.YeshowTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Login {
                LoginContent()
            }
        }
    }
}


@Composable
fun Login(content: @Composable () -> Unit) {
    YeshowTheme {
        Scaffold(

        ) {
            content()
        }
    }
}

@Preview
@Composable
fun LoginContent() {
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()){
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(horizontal = 24.dp)
                .fillMaxWidth(),
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            Text(text = "우리 동네 인기 식당 TOP 3", fontSize = dpToSp(dp = 22.dp), color = TextColor, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "뭘 먹을지 모르겠다고요? \n" +
                    "지금 가장 핫한 식당을 살펴보세요!", fontSize = dpToSp(dp = 16.dp), color = TextSub, fontWeight = FontWeight.Medium, lineHeight = dpToSp(
                dp = 22.dp
            ))
            Spacer(modifier = Modifier.height(34.dp))
            Column(  verticalArrangement = Arrangement.spacedBy(26.dp)) {
                RestaurantCard(restaurantTitle = "이자와 숙대입구점", category = "일식", grade = 4.8F)
                RestaurantCard(restaurantTitle = "이자와 숙대입구점", category = "일식", grade = 4.8F)
                RestaurantCard(restaurantTitle = "이자와 숙대입구점", category = "일식", grade = 4.8F)
            }
        }
    }
}


