package com.example.jetpackcomponentcatalog

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material3.AlertDialog
import androidx.compose.material.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun MyConfirmatiomnDialog(
    show: Boolean,
    onDismiss: () -> Unit

) {
    if (show) {

        Card (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            elevation = 60.dp,
            shape = MaterialTheme.shapes.medium,
            //backgroundColor = Color.Yellow,
            contentColor = Color.Red,
            border = BorderStroke(0.dp, Color.Black)

        ){


      //  Dialog(onDismissRequest = { onDismiss() }) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                MyTitleDialog(text = "Phone ringtone", modifier = Modifier.padding(24.dp))
                Divider(Modifier.fillMaxWidth(), color=Color.LightGray)
                var status by remember { mutableStateOf("") }

                MyRadioButtonListl(status, { status=it} )
                Divider(Modifier.fillMaxWidth(), color=Color.LightGray)
                Row (
                    Modifier
                        .align(Alignment.End)
                        .padding(8.dp)){
                    TextButton(onClick = { }) {
                        Text(text ="Cancel")
                    }
                    TextButton(onClick = { }) {
                        Text(text ="ok")
                    }

                }


            }
      //  }
        }



    }


}

@Composable
fun MyCustomDialog(
    show: Boolean,
    onDismiss: () -> Unit
) {
    if (show) {

        Dialog(
            onDismissRequest = { onDismiss() }) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()

            ) {
                Text(text = "Esto es un ejemplo")

            }

        }
    }

}

@Composable
fun MySimpleCustomDialog(
    show: Boolean,
    onDismiss: () -> Unit

) {
    if (show) {

        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
        ) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()

            ) {
                MyTitleDialog("Set backup account")
                AccounItem("Ejemplo1@gmail.com", R.drawable.avatar)
                AccounItem("Ejemplo2@gmail.com", R.drawable.avatar)
                AccounItem("Añadir nueva cueenta", R.drawable.add)
            }
        }
    }

}

@Composable
fun MyAlertDialog(
    show: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    if (show) {
        AlertDialog(onDismissRequest = { onDismiss() },
            title = { Text(text = "Titulo") },
            text = { Text(text = "Soy una descripcion super guay :) ") },
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "ConfirmButton")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = "DismisButton")
                }
            }
        )

    }
}

@Composable
fun AccounItem(email: String, @DrawableRes drawable: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { Log.i("JoseLuis", "jjjjjjjjjjjjjjjjj") }) {

        Image(
            painter = painterResource(id = drawable),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
        )
        Text(text = email, fontSize = 14.sp, color = Color.Gray, modifier = Modifier.padding(8.dp))

    }
}

@Composable
fun MyTitleDialog(text: String,modifier: Modifier=Modifier.padding(bottom = 12.dp) ){
    Text(
        text = text,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = Modifier.padding(12.dp)
    )
}