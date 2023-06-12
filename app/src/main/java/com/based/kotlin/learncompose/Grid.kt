package com.based.kotlin.learncompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.based.kotlin.learncompose.model.DataSource
import com.based.kotlin.learncompose.model.Topic

@Composable
fun GridList(){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ) {
        items (DataSource.topics){
            GridCard(it)
        }
    }
}

@Composable
fun GridCard(topic: Topic) {
    Card(
        elevation = CardDefaults.cardElevation(2.dp),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(68.dp)
        ) {
            Image(
                painter = painterResource(topic.images),
                contentDescription = "",
                modifier = Modifier
                    .width(68.dp)
                    .fillMaxHeight(),
                contentScale = ContentScale.FillBounds
            )
            Column(
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp)
            ) {
                Text(
                    text = stringResource(topic.title),
                    style = MaterialTheme.typography.bodyMedium
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(top = 8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = ""
                    )
                    Text(
                        text = topic.view.toString(),
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier
                            .padding(start = 8.dp)
                    )
                }
            }
        }
    }
}