package com.based.kotlin.learncompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = Color.White
                ) {
                    GridList()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingImagesPreview() {
    LearnComposeTheme {
        GreetingImages(
            message = stringResource(R.string.happy_birthday_adit),
            from = stringResource(R.string.name)
        )
    }
}
@Composable
fun GreetingImages(
    from: String,
    message: String,
    modifier: Modifier = Modifier
) {
    val images = painterResource(id = R.drawable.androidparty)
    Image(
        painter = images,
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = message,
                fontSize = 90.sp,
                textAlign = TextAlign.Center,
                lineHeight = 110.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 16.dp,
                        bottom = 16.dp,
                        start = 16.dp,
                        end = 16.dp
                    )
            )
            Text(
                text = from,
                fontSize = 36.sp,
                modifier = Modifier
                    .padding(16.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )
        }
    }
}

