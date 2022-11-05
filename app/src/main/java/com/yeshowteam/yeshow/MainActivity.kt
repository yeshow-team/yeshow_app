package com.yeshowteam.yeshow

import android.os.Bundle
import android.view.View.OnClickListener
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
             MyApp {
                 MainContent()
             }
        }
    }
}


@Composable
fun MyApp(content: @Composable () -> Unit) {
    YeshowTheme {
        Scaffold(
            topBar = {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        ) {
                    Row(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(horizontal = 24.dp)
                            .fillMaxWidth(),
                        Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    )
                    {
                        val image: Painter = painterResource(id = R.drawable.logo)
                        Image(painter = image, contentDescription = "hello", modifier = Modifier.height(20.dp))
                        Row {
                            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(24.dp)) {
                                Icon(Icons.Rounded.Search, contentDescription = "Localized description", tint = Color.Black)
                            }

                        Spacer(modifier = Modifier.size(20.dp))
                            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(24.dp)) {
                                Icon(Icons.Rounded.Menu, contentDescription = "Localized description", tint = Color.Black)
                            }
                        }
                    }
                }
            },
        ) {
            content()
        }
    }
}

@Preview
@Composable
fun MainContent() {
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
            Spacer(modifier = Modifier.height(40.dp))
            Text(text = "내 재 주변 식ㅜ벼", fontSize = dpToSp(dp = 22.dp), color = TextColor, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "뭘 먹을지 모르겠다고요? \n" +
                    "지금 가장 핫한 식당을 살펴보세요!", fontSize = dpToSp(dp = 16.dp), color = TextSub, fontWeight = FontWeight.Medium, lineHeight = dpToSp(
                dp = 22.dp
            ))
            Spacer(modifier = Modifier.height(21.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .height(80.dp),
                Arrangement.SpaceBetween
            ) {
                CategoryButton(categoryName = "일식", onclick = {})
                CategoryButton(categoryName = "일식", onclick = {})
                CategoryButton(categoryName = "일식", onclick = {})
                CategoryButton(categoryName = "일식", onclick = {})
            }
            Spacer(modifier = Modifier.height(34.dp))
            Column(  verticalArrangement = Arrangement.spacedBy(26.dp)) {
                RestaurantCard(restaurantTitle = "이자와 숙대입구점", category = "일식", grade = 4.8F)
                RestaurantCard(restaurantTitle = "이자와 숙대입구점", category = "일식", grade = 4.8F)
                RestaurantCard(restaurantTitle = "이자와 숙대입구점", category = "일식", grade = 4.8F)
            }
        }
    }
}

@Composable
fun dpToSp(dp: Dp) = with(LocalDensity.current) { dp.toSp() }

@Composable
fun RestaurantCard(restaurantTitle:String,category:String,grade:Float) {
    Row(
        modifier = Modifier
            .fillMaxWidth(1f)
            .height(96.dp),
            Arrangement.SpaceBetween
    ) {
        Column {
            Text(text=category, fontSize = dpToSp(14.dp), color = TextSub, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(7.dp))
            Text(text=restaurantTitle, fontSize = dpToSp(20.dp), color = TextColor, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(7.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically){
                Icon(Icons.Rounded.Restaurant, contentDescription = "Localized description", tint = PrimaryColor, modifier = Modifier.size(18.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text(text="${grade}/5.0점", fontSize = dpToSp(15.dp), color = PrimaryColor, fontWeight = FontWeight.Medium)
            }
        }
        Row(
            Modifier
                .background(color = Color.Black)
                .size(96.dp)){
        }
    }
}

@Composable
fun CategoryButton(categoryName:String,onclick:() -> Unit) {
    OutlinedButton(
        modifier = Modifier
            .width(76.dp)
            .height(35.dp)
            .background(color = PrimaryColor),
                shape = RoundedCornerShape(25),
        onClick = onclick
    ) {
        Text(text=categoryName)
    }

}

