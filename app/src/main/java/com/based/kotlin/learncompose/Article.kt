package com.based.kotlin.learncompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.based.kotlin.learncompose.ui.theme.LearnComposeTheme

@Preview(showBackground = true)
@Composable
fun ArticlePreview() {
    LearnComposeTheme {
        Article(
            title = stringResource(R.string.title),
            header = stringResource(R.string.header),
            content = stringResource(R.string.content),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun Article(title: String, header: String, content: String, modifier: Modifier = Modifier) {
    val images = painterResource(id = R.drawable.bg_compose_background)
    Column {
        Image(
            painter = images,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
        )
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = header,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = content,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}