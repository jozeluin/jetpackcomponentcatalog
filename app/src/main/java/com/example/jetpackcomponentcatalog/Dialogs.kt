package com.example.jetpackcomponentcatalog

import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material3.AlertDialog
import androidx.compose.runtime.Composable

@Composable
fun MyDialog(
    show:Boolean,
    onDismiss:()->Unit,
    onConfirm:()->Unit
             ) {
    if(show){
    AlertDialog(onDismissRequest = {onDismiss()},
        title = { Text(text = "Titulo") },
        text = { Text(text = "Soy una descripcion super guay :) ") },
        confirmButton = {
            TextButton(onClick = {onConfirm() }) {
                Text(text = "ConfirmButton")
            }
        },
        dismissButton = {
            TextButton(onClick = {onDismiss() }) {
                Text(text = "DismisButton")
            }
        }
    )

}
}