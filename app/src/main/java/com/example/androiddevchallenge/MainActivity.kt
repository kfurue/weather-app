/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.typography
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.apply {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                setDecorFitsSystemWindows(false)
            } else {
                @Suppress("DEPRECATION")
                decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            }
        }
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    Surface(color = MaterialTheme.colors.background) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.size(72.dp))
            Text(
                "Today",
                style = typography.h4,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = "🌦",
                fontSize = 144.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Chance of Rain: 100%\n" +
                    "18℃/11℃",
                style = typography.body1,
                textAlign = TextAlign.Center
            )
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp)
            ) {
                items(14) { index ->
                    val rightNow = Calendar.getInstance()
                    rightNow.add(Calendar.DATE, index)
                    val emoji = when (index) {
                        0 -> "🌤"
                        1 -> "🌥"
                        2 -> "🌧"
                        3 -> "☀️"
                        4 -> "☃️"
                        5 -> "🌤"
                        6 -> "🌥"
                        7 -> "🌧"
                        8 -> "☀️"
                        9 -> "☃️"
                        10 -> "🌤"
                        11 -> "🌥"
                        12 -> "🌧"
                        13 -> "☀️"
                        else -> ""
                    }
                    Row {
                        Text(
                            text = emoji,
                            fontSize = 64.sp
                        )
                        Column(Modifier.padding(horizontal = 16.dp)) {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                Text(
                                    rightNow.getDisplayName(
                                        Calendar.DAY_OF_WEEK,
                                        Calendar.LONG_FORMAT,
                                        Locale.US
                                    ),
                                    style = typography.h6,
                                    color = MaterialTheme.colors.onPrimary,
                                    modifier = Modifier
                                        .paddingFromBaseline(32.dp)
                                )
                            }
                            Text(
                                "Chance of Rain: 100%\n" +
                                    "18℃/11℃",
                                style = typography.body2,
                                color = MaterialTheme.colors.onPrimary,
                                modifier = Modifier
                                    .padding(horizontal = 16.dp)
                            )
                        }
                    }
                    Divider(
                        color = MaterialTheme.colors.onPrimary,
                        thickness = 1.dp,
                        startIndent = 80.dp,
                    )
                }
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
