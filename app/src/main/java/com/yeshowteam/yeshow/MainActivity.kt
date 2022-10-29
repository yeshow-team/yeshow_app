package com.yeshowteam.yeshow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.rounded.Search
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
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
    Surface(color = MaterialTheme.colors.background) {
        Text(text = "Hello")
    }
}
