package com.tanaplay.jccounterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tanaplay.jccounterapp.ui.theme.JCcounterAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JCcounterAppTheme(
                darkTheme = true,
                content = {
                    Counter()
                }
            )
        }
    }
}

@Composable
fun Counter() {
    var count by remember {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        content = {
            Text(
                text = count.toString(),
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 70.sp
                )

            )
            Spacer(modifier = Modifier.height(40.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                content = {
                    Button(
                        onClick = {
                            count--
                        },
                        colors = ButtonDefaults.buttonColors(
                            Color.Gray,
                            Color.White
                        ),
                        modifier = Modifier
                            .width(120.dp)
                            .height(60.dp)
                            .clip(RoundedCornerShape(30.dp))
                            .border(
                                BorderStroke(1.dp, Color.Gray),
                            ),
                        content = {
                            Text(text = "Decrease")
                        }
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Button(
                        onClick = {
                            count++
                        },
                        colors = ButtonDefaults.buttonColors(
                            Color.DarkGray,
                            Color.White

                        ),
                        modifier = Modifier
                            .width(120.dp)
                            .height(60.dp)
                            .clip(RoundedCornerShape(30.dp))
                            .border(
                                BorderStroke(1.dp, Color.DarkGray),
                            ),
                        content = {
                            Text(text = "Increase")
                        }
                    )
                }
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JCcounterAppTheme {
        Counter()
    }
}