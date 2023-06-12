package com.based.kotlin.learncompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.based.kotlin.learncompose.ui.theme.LearnComposeTheme

class Practice : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = Color.White
                ) {
                    Dice()
                }
            }
        }
    }
}

@Composable
fun LemonApp() {
    // Current step the app is displaying (remember allows the state to be retained
    // across recompositions).
    var currentStep by remember { mutableStateOf(1) }

    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when (currentStep) {
            1 -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(text = "Lemon")
                    Spacer(modifier = Modifier.height(32.dp))
                    Image(
                        painter = painterResource(R.drawable.lemon_tree),
                        contentDescription = "Lemon",
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable {
                                currentStep = 2
                            }
                    )
                }
            }

            2 -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(text = "Squeeze")
                    Spacer(
                        modifier = Modifier.height(
                            32
                                .dp
                        )
                    )
                    Image(
                        painter = painterResource(R.drawable.lemon_squeeze),
                        contentDescription = "Squeeze",
                        modifier = Modifier.wrapContentSize()
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TreePracticePreview() {
    LearnComposeTheme {
        TreePracticeImages()
    }
}

@Composable
fun TreePracticeImages() {
    var result by remember { mutableStateOf(1) }
    val imageResource = when (result) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val textResult = when (result) {
        1 -> "Tap the lemon tree to select a lemon"
        2 -> "Keep tapping the lemon to squeeze it"
        3 -> "Tap the lemonade to drink it"
        else -> "Tap the empty glass to start again"
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card (
            shape = RoundedCornerShape(4.dp),
            colors = CardDefaults.cardColors(containerColor = Color.LightGray)
        )
        {
            Image(
                painter = painterResource(imageResource),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)
                    .padding(8.dp)
                    .clickable {
                        when(result) {
                            2 -> result = (2..4).random()
                            4 -> result = 1
                            else -> result += 1
                        }
                    }
            )
        }
        Text(
            text = textResult,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 24.dp)
        )
    }
}
