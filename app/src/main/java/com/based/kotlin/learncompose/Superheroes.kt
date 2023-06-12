package com.based.kotlin.learncompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.based.kotlin.learncompose.model.Hero
import com.based.kotlin.learncompose.model.HeroesRepository
import com.based.kotlin.learncompose.ui.theme.LearnComposeTheme

class Superheroes : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    SuperheroesApp()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SuperheroesPreview() {
    LearnComposeTheme {
        SuperheroesApp()
    }
}

@Composable
fun SuperheroesApp() {
    SuperheroesList(
        hero = HeroesRepository.heroes,
        modifier = Modifier.padding(8.dp)
    )
}

@Composable
fun SuperheroesList(hero: List<Hero>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(hero) { hero ->
            SuperheroesCard(hero = hero, modifier = Modifier.padding(8.dp))

        }
    }
}

@Composable
fun SuperheroesCard(hero: Hero, modifier: Modifier) {
    Card(modifier = modifier) {
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = LocalContext.current.getString(hero.nameRes),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = LocalContext.current.getString(hero.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Image(
                painter = painterResource(id = hero.imageRes),
                contentDescription = stringResource(id = hero.descriptionRes),
                modifier = Modifier
                    .height(72.dp)
                    .width(72.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.FillBounds
            )
        }
    }
}