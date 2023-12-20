package com.example.jetpackcomponentcatalog

import android.annotation.SuppressLint

import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp




import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add

import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.rememberScaffoldState

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue

import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScaffoldExample() {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()



    Scaffold(
        topBar = {
            MyTopAppBar(OnClickIcon= {
                coroutineScope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(
                        "Has pulsado $it"
                    )
                }
            }, OnClickDrawer={coroutineScope.launch { scaffoldState.drawerState.open() }})
        },
        scaffoldState = scaffoldState,
        bottomBar = { MyBottonNavigation() },
        floatingActionButton = { MyFab() },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = false,
        drawerContent = { MyDrawer() {coroutineScope.launch { scaffoldState.drawerState.close() }}},
        drawerGesturesEnabled = false
    ) {

    }
}

@Composable
fun MyTopAppBar(OnClickIcon: (String) -> Unit,OnClickDrawer:()->Unit) {
    TopAppBar(title = { Text(text = "Hola soy mi Toolbar") },
        backgroundColor = Color.Magenta,
        contentColor = Color.White,
        elevation = 8.dp,
        navigationIcon = {
            IconButton(onClick = { OnClickDrawer()}) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")

            }
        },
        actions = {
            IconButton(onClick = { OnClickIcon("Busqueda") }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "search")

            }
            IconButton(onClick = { OnClickIcon("Peligro") }) {
                Icon(imageVector = Icons.Filled.Warning, contentDescription = "Warning")

            }
        }


    )
}

@Composable
fun MyBottonNavigation() {

    var index by remember { mutableStateOf(0) }

    BottomNavigation(backgroundColor = Color.Magenta, contentColor = Color.White) {
        BottomNavigationItem(selected = index == 0, onClick = { index = 0 }, icon = {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "home"
            )
        }, label = { Text(text = "Home") })


        BottomNavigationItem(selected = index == 1, onClick = { index = 1 }, icon = {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "fav"
            )
        }, label = { Text(text = "Fav") }
        )


        BottomNavigationItem(selected = index == 2, onClick = { index = 2 }, icon = {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "person"
            )
        }, label = { Text(text = "Person") }
        )


    }


}

@Composable
fun MyFab() {
    FloatingActionButton(onClick = {}, backgroundColor = Color.Yellow, contentColor = Color.Black) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "add")

    }
}

@Composable
fun MyDrawer(onCloserDrawer:()->Unit) {
    Column(Modifier.padding(8.dp)) {
        Text(
            text = "Primera opcion", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp).clickable { onCloserDrawer() }
        )
        Text(
            text = "Segunda opcion", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp).clickable { onCloserDrawer() }
        )

        Text(
            text = "Tercera opcion", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp).clickable { onCloserDrawer() }
        )

        Text(
            text = "Cuarta opcion", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp).clickable { onCloserDrawer() }
        )


    }

}