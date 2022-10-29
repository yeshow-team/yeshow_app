package com.yeshowteam.yeshow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.material.icons.rounded.Search
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
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
                        Row(

                        ) {
                            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(20.dp)) {
                                Icon(Icons.Rounded.Search, contentDescription = "Localized description", tint = Color.Black)
                            }

                        Spacer(modifier = Modifier.size(20.dp))
                            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(20.dp)) {
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
            Arrangement.SpaceBetween,
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(26.dp)) {
                item {
                    RestaurantCard(restaurantTitle = "이자와 숙대입구점", category = "일식", grade = 4.8F)
                    RestaurantCard(restaurantTitle = "이자와 숙대입구점", category = "일식", grade = 4.8F)
                    RestaurantCard(restaurantTitle = "이자와 숙대입구점", category = "일식", grade = 4.8F)
                    RestaurantCard(restaurantTitle = "이자와 숙대입구점", category = "일식", grade = 4.8F)
                }
            }
        }
    }
}

@Composable
fun dpToSp(dp: Dp) = with(LocalDensity.current) { dp.toSp() }

@Composable
fun RestaurantCard(restaurantTitle:String,category:String,grade:Float) {
    Row(         modifier = Modifier
        .fillMaxWidth(1f)
        .height(96.dp),
        Arrangement.SpaceBetween) {
        Column(){
            Text(text=category, fontSize = dpToSp(14.dp), color = Color.Black, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(7.dp))
            Text(text=restaurantTitle, fontSize = dpToSp(20.dp), color = Color.Black, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(7.dp))
            Text(text=grade.toString(), fontSize = dpToSp(15.dp), color = Color.Black, fontWeight = FontWeight.Medium)
        }
        Row(
            Modifier
                .background(color = Color.Black)
                .size(96.dp)){

        }
    }
}