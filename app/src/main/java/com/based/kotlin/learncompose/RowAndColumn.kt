package com.based.kotlin.learncompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.based.kotlin.learncompose.ui.theme.LearnComposeTheme

@Preview(showBackground = true)
@Composable
fun RowAndColumnPreview() {
    LearnComposeTheme {
        RowAndColumn(
            title1 = "Text composable\n",
            title2 = "Image composable\n",
            title3 = "Row composable\n",
            title4 = "Column composable\n",
            content1 = "Displays text and follows the recommended Material Design guidelines.\n",
            content2 = "Creates a composable that lays out and draws a given Painter class object.\n",
            content3 = "A layout composable that places its children in a horizontal sequence.\n",
            content4 = "A layout composable that places its children in a vertical sequence.\n",
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun RowAndColumn(
    title1: String,
    title2: String,
    title3: String,
    title4: String,
    content1: String,
    content2: String,
    content3: String,
    content4: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) {
            Column(
                modifier = Modifier
                    .background(color = Color(0xFFEADDFF))
                    .padding(16.dp)
                    .fillMaxSize()
                    .weight(1f)
            ) {
                Text(
                    text = title1,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Justify,
                )
                Text(
                    text = title1,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Justify,
                )
            }
            Column(
                modifier = Modifier
                    .background(color = Color(0xFFEADDFF))
                    .padding(16.dp)
                    .fillMaxSize()
                    .weight(1f)
            ) {
                Text(
                    text = title1,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Justify,
                )
                Text(
                    text = title1,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Justify,
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) {
            Column(
                modifier = Modifier
                    .background(color = Color(0xFFEADDFF))
                    .padding(16.dp)
                    .fillMaxSize()
                    .weight(1f)
            ) {
                Text(
                    text = title1,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Justify,
                )
                Text(
                    text = title1,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Justify,
                    fontWeight = FontWeight.Bold
                )
            }
            Column(
                modifier = Modifier
                    .background(color = Color(0xFFEADDFF))
                    .padding(16.dp)
                    .fillMaxSize()
                    .weight(1f)
            ) {
                Text(
                    text = title1,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Justify,
                )
                Text(
                    text = title1,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Justify,
                )
            }
        }
    }
}