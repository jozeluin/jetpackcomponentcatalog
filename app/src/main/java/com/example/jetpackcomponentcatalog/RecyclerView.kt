package com.example.jetpackcomponentcatalog

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomponentcatalog.model.SuperHero

@Composable
fun SimpleRecyclerView() {
    val myList = listOf("Aristidev", "Pepillo", "Jose Lillo", "Veracruz")

    LazyColumn {
        item { Text(text = "Hola") }
        items(7) {
            Text(text = "Este es el item $it")
        }
        items(myList) {
            Text(text = "Hola yo soy el sinverguenza llamado $it")
        }
    }
}

@Composable
fun SuperHeroView() {
    val context = LocalContext.current
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperheroes()) {
            ItemHero(superHero = it)
            {
                Toast.makeText(context, it.superheroName, Toast.LENGTH_SHORT).show()
            }

        }
    }

}

@ExperimentalFoundationApi
@Composable
fun SuperHeroStickyView() {
    val context = LocalContext.current
    val superhero: Map<String, List<SuperHero>> = getSuperheroes().groupBy { it.publisher }

    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {

        superhero.forEach { (publisher, mySuperHero) ->

            stickyHeader {
                Text(
                    text = publisher,
                    modifier = Modifier.fillMaxWidth(). background (Color.Green),
                    fontSize = 16.sp,
                    color = Color.White
                )
            }

            items(mySuperHero) {
                ItemHero(superHero = it)
                {
                    Toast.makeText(context, it.superheroName, Toast.LENGTH_SHORT).show()
                }

            }
        }


    }

}


@Composable
fun SuperHeroWithSpecialControlView() {
    val context = LocalContext.current
    val rvState = rememberLazyListState()

    Column {
        LazyColumn(
            state = rvState,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(getSuperheroes()) {
                ItemHero(superHero = it)
                { Toast.makeText(context, it.superheroName, Toast.LENGTH_SHORT).show() }
            }
        }

        Button(onClick = {}) {
            Text(text = "Soy ese boton")
        }
    }


}


@Composable
fun SuperHeroViGridew() {
    val context = LocalContext.current
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        content = {
            items(getSuperheroes()) {
                ItemHero(superHero = it)
                {
                    Toast.makeText(context, it.superheroName, Toast.LENGTH_SHORT).show()
                }

            }
        }, contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    )


}


@Composable
fun ItemHero(superHero: SuperHero, onItemSelected: (SuperHero) -> Unit) {
    Card(
        border = BorderStroke(2.dp, Color.Red),


        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemSelected(superHero) }) {
        Column() {
            Image(
                painter = painterResource(id = superHero.photo),
                contentDescription = "SuperHero Avatar",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = superHero.superheroName,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = superHero.realname,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )
            Text(
                text = superHero.publisher,
                fontSize = 10.sp,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(8.dp)
            )

        }

    }

}


fun getSuperheroes(): List<SuperHero> {
    return listOf(
        SuperHero("Spiderman", "Peter Paker", "Marvel", R.drawable.spiderman),
        SuperHero("Wolverine", "James Howlet", "Marvel", R.drawable.logan),
        SuperHero("Batman", "Bruce Wane", "Dc", R.drawable.batman),
        SuperHero("Flash", "Jey Garrik", "Dc", R.drawable.flash),
        SuperHero("Thor", "Thor Odison", "Marvel", R.drawable.thor),
        SuperHero("Green lantern", "Alan Scott", "Dc", R.drawable.green_lantern),
        SuperHero("Wonder Woman", "Princess Diana", "Marvel", R.drawable.wonder_woman),


        )
}
