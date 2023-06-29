package com.aqua30.apimocking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aqua30.apimocking.ui.theme.ApiMockingTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: JokeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApiMockingTheme {

                var mainLine by remember {
                    mutableStateOf("")
                }
                var punchLine by remember {
                    mutableStateOf("")
                }

                LaunchedEffect(true) {
                    viewModel.jokeFlow.collect { joke ->
                        mainLine = joke.setup
                        punchLine = joke.punchline
                    }
                }

                Column(
                    modifier = Modifier.fillMaxSize().padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        mainLine,
                        textAlign = TextAlign.Center,
                        fontSize = 22.sp,
                        color = Color.Black
                    )
                    Text(
                        punchLine,
                        textAlign = TextAlign.Center,
                        fontSize = 28.sp,
                        color = Color.Magenta
                    )
                    Button(
                        colors = ButtonDefaults.outlinedButtonColors(Color.Cyan),
                        onClick = { viewModel.getJoke() }) {
                        Text(
                            "Get me a new joke",
                            fontSize = 20.sp,
                            color = Color.Blue
                        )
                    }
                }
            }
        }
    }
}