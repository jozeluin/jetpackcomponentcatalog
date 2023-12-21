package com.example.jetpackcomponentcatalog

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.jetpackcomponentcatalog.model.Routes
import com.example.jetpackcomponentcatalog.model.Routes.Pantalla2
import com.example.jetpackcomponentcatalog.model.Routes.Pantalla3

@Composable
fun Screeen1(navController: NavHostController) {
    Box (
        modifier= Modifier
            .fillMaxSize()
            .background(Color.Cyan)

    ){
        Text(text = "Pantalla 1", modifier = Modifier.align(Alignment.Center).clickable { navController.navigate(Pantalla2.route)})

    }
}
@Composable
fun Screeen2(navController: NavHostController){
    Box (
        modifier= Modifier
            .fillMaxSize()
            .background(Color.Blue)

    ){
        Text(text = "Pantalla 2", modifier = Modifier.align(Alignment.Center).clickable { navController.navigate(
            Pantalla3.route) })

    }
}
@Composable
fun Screeen3(navController: NavHostController){
    Box (
        modifier= Modifier
            .fillMaxSize()
            .background(Color.Magenta)

    ){
        Text(text = "Pantalla 3", modifier = Modifier.align(Alignment.Center).clickable { navController.navigate("pantalla4/2") })

    }
}

@Composable
fun Screeen4(navController: NavHostController,age:Int){
    Box (
        modifier= Modifier
            .fillMaxSize()
            .background(Color.White)

    ){
        Text(text = "Tengo $age años", modifier = Modifier.align(Alignment.Center).clickable { navController.navigate(
          Routes.Pantalla5.createRoute("JoseLuis")
          //  "pantalla5"
        ) })

    }
}

@Composable
fun Screeen5(navController: NavHostController,name:String? ){
    Box (
        modifier= Modifier
            .fillMaxSize()
            .background(Color.Green)

    ){
        Text(text = "Me llamo $name", modifier = Modifier.align(Alignment.Center))

    }
}