package com.based.kotlin.learncompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.based.kotlin.learncompose.ui.theme.LearnComposeTheme

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    LearnComposeTheme {
        Cards()
    }
}

@Composable
fun Cards() {
    val images = painterResource(id = R.drawable.androidparty)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
        ) {
            Image(
                painter = images,
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
            )
            Text(
                text = "Dirza and Adit",
                fontSize = 24.sp
            )
            Text(
                text = "Dirza and Adit",
                fontSize = 16.sp
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {
            Row {
                Image(
                    painter = images,
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .width(25.dp)
                        .height(25.dp)
                )
                Text(
                    text = "Dirza and Adit",
                    modifier = Modifier
                        .padding(start = 16.dp)
                )
            }
            Row {
                Image(
                    painter = images,
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .width(25.dp)
                        .height(25.dp)
                )
                Text(
                    text = "Dirza and Adit",
                    modifier = Modifier
                        .padding(start = 16.dp)
                )
            }
            Row {
                Image(
                    painter = images,
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .width(25.dp)
                        .height(25.dp)
                )
                Text(
                    text = "Dirza and Adit",
                    modifier = Modifier
                        .padding(start = 16.dp)
                )
            }
        }
    }
}