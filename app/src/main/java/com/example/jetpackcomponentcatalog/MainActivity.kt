package com.example.jetpackcomponentcatalog

//import androidx.compose.material3.TextField
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomponentcatalog.ui.theme.JetpackcomponentcatalogTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackcomponentcatalogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // var myText by remember { mutableStateOf("texto informativo") }
                    //  MyTextField(myText){myText=it}

                    Column() {
                        MyButtonExample()
                    }

                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackcomponentcatalogTheme {
        MyButtonExample()
    }
}


@Composable
fun MyButtonExample() {

    var enabled by rememberSaveable { mutableStateOf(true) }

    Column(
        Modifier
            .fillMaxSize()
            .padding(100.dp)
    ) {
        Button(
            onClick = { enabled = false },
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta,
                contentColor = Color.Blue
            ),
            border = BorderStroke(3.dp, Color.Green)
        ) {

            Text(text = "Hola")


        }

    }

}


@Composable
fun MyTextFieldOutlined() {
    var myText by remember { mutableStateOf("") }

    OutlinedTextField(
        value = myText,
        onValueChange = { myText = it },
        modifier = Modifier.padding(24.dp),
        label = { Text(text = "hello") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Magenta,
            unfocusedBorderColor = Color.Green

        )
    )

}


@Composable
fun MyTextFieldAdvance() {
    var myText by remember { mutableStateOf("") }

    TextField(
        value = myText,
        onValueChange = {
            myText =
                if (it.contains("a")) {
                    it.replace("a", "eso no")
                } else {
                    it
                }


        },
        label = { Text(text = "Introduce nombre") })


}


@Composable
fun MyTextField(name: String, onValueChanged: (String) -> Unit) {


    TextField(value = name, onValueChange = { onValueChanged(it) })

}

@Composable
fun MyText() {

    Column(Modifier.fillMaxSize()) {
        Text(text = "Esto es mi ejemplo")
        Text(text = "Esto es otro ejemplo", color = Color.Blue)
        Text(text = "Esto es otro ejemplo", fontWeight = FontWeight.ExtraBold)
        Text(text = "Esto es otro ejemplo", fontWeight = FontWeight.Light)
        Text(text = "Esto es otro ejemplo", fontFamily = FontFamily.Cursive)
        Text(
            text = "Esto es otro ejemplo",
            textDecoration = TextDecoration.Underline
        )

        Text(
            text = "Esto es otro ejemplo",
            style = TextStyle(textDecoration = TextDecoration.LineThrough)
        )
        Text(
            text = "Esto es otro ejemplo", style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(TextDecoration.Underline, TextDecoration.LineThrough)

                )
            )
        )
        Text(text = "Esto es mi ejemplo", fontSize = 50.sp)
    }

}