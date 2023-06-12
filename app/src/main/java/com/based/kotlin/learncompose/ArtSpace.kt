package com.based.kotlin.learncompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.unit.dp

@Composable
fun ArtSpace() {
    var result by remember { mutableStateOf(1) }
    val imageResource = when (result) {
        1 -> R.drawable.lemon_squeeze
        2 -> R.drawable.lemon_drink
        3 -> R.drawable.lemon_restart
        else -> R.drawable.lemon_tree
    }
    val titleResources = when (result) {
        1 -> stringResource(R.string.title_1)
        2 -> stringResource(R.string.title_2)
        3 -> stringResource(R.string.title_3)
        else -> stringResource(R.string.title_4)
    }
    val yearResources = when (result) {
        1 -> "Dirza (2011)"
        2 -> "Adit (2014)"
        3 -> "Devis (1992)"
        else -> "Jalal (2019)"
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        ArtCardImages(imageResource)
        ArtDesc(titleResources, yearResources)
        ArtButton(
            onClickPrev = { result = onClickPrevious(result) },
            onClickNext = { result = onClickNext(result) }
        )
    }
}

private fun onClickPrevious(result: Int) : Int = when(result) {
    1 -> 4
    else -> result - 1
}

private fun onClickNext(result: Int) : Int = when(result){
    4 -> 1
    else -> result + 1
}

@Composable
private fun ColumnScope.ArtCardImages(imageResource: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .align(alignment = Alignment.CenterHorizontally)
            .padding(8.dp)
            .weight(1f),
        contentAlignment = Alignment.Center
    ) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(4.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 100.dp)
        ) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = "Images",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            )
        }
    }
}

@Composable
private fun ArtDesc(titleResources: String, yearResources: String) {
    Card(
        shape = RoundedCornerShape(2.dp),
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = titleResources,
                textAlign = TextAlign.Justify
            )
            Text(text = yearResources)
        }
    }
}

@Composable
private fun ArtButton(onClickPrev: () -> Unit, onClickNext: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        OutlinedButton(
            onClick = { onClickPrev() },
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(end = 4.dp)
        ) {
            Text(text = "Previous")
        }
        OutlinedButton(
            onClick = { onClickNext() },
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(start = 4.dp)
        ) {
            Text(text = "Next")
        }
    }
}