package com.example.jetpackcomponentcatalog

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign

@Composable
fun BasicSlider() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var sliderPosition by remember { mutableStateOf(0f) }
        Slider(value = sliderPosition, onValueChange = { sliderPosition = it })
        Text(text = sliderPosition.toString(), textAlign = TextAlign.Center)
    }


}

/**
 * Con material3, se consigue lo mismos sin tanto lio
 *
 */
@Composable
fun AdavanceSlider() {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var sliderPosition by remember { mutableStateOf(0f) }
        var completeValue by remember { mutableStateOf("") }
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            onValueChangeFinished = {completeValue=sliderPosition.toString()},
            valueRange = 0f..10f,
            steps=9,
            enabled = true
        )
        Text(text = completeValue, textAlign = TextAlign.Center)
    }

}