package com.example.jetpackcomponentcatalog

//import androidx.compose.material3.TextField

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Badge
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TriStateCheckbox
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomponentcatalog.model.Routes
import com.example.jetpackcomponentcatalog.ui.CheckInfo
import com.example.jetpackcomponentcatalog.ui.theme.JetpackcomponentcatalogTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackcomponentcatalogTheme {
                // A surface container using the 'background' color from the theme


                Surface(
                    //modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )
                {
                   val navigationController= rememberNavController()
                    NavHost(navController = navigationController, startDestination = Routes.Pantalla1.route){
                        composable(Routes.Pantalla1.route){ Screeen1(navigationController)}
                        composable(Routes.Pantalla2.route){ Screeen2(navigationController)}
                        composable(Routes.Pantalla3.route){ Screeen3(navigationController)}
                    }
                }


            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SuperHeroWithSpecialControlView()
}

@Composable
fun MyDropDownMenu() {

    var selectedText by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var desserts = listOf("Helado", "Chocolate", "Cafe", "Fruta", "Natillas", "Chilaquiles")

    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth(),
            label = { Text("Escribe aqui", color = Color.Magenta) }
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            desserts.forEach { postre ->
                DropdownMenuItem(onClick = {
                    expanded = false
                    selectedText = postre


                }) {
                    Text(text = postre, color = Color.Magenta)
                }

            }

        }

    }

}

@Composable
fun MyRadioButton() {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        RadioButton(
            selected = false, onClick = { }, enabled = false, colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Yellow,
                disabledColor = Color.Green

            )
        )
        Text(text = "Ejemplo1")
    }

}


@Composable
fun MyRadioButtonListl(name: String, onItemSelected: (String) -> Unit) {


    Column(Modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = name == "JoseLuis", onClick = { onItemSelected("JoseLuis") })
            Text(text = "JoseLuis")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = name == "Xavi", onClick = { onItemSelected("Xavi") })
            Text(text = "Xavi")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = name == "Mayte", onClick = { onItemSelected("Mayte") })
            Text(text = "Mayte")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = name == "Victor", onClick = { onItemSelected("Victor") })
            Text(text = "Victor")
        }

    }

}


@Composable
fun MyDivider() {
    Divider(
        Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        color = Color.Magenta
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBadBox() {

    BadgedBox(
        modifier = Modifier.padding(160.dp),
        badge = {
            Badge(
                content = { Text("100") },
                modifier = Modifier.size(40.dp),
                backgroundColor = Color.Blue,
                contentColor = Color.Green
            )
        }) {
        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = "Estrella", Modifier.size(90.dp)
        )
    }
}

@Composable
fun MyCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 60.dp,
        shape = MaterialTheme.shapes.medium,
        backgroundColor = Color.Magenta,
        contentColor = Color.White,
        border = BorderStroke(1.dp, Color.Black)

    ) {
        Text(text = "hhhhhhh")

        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Ejemplo 1")
            Text(text = "Ejemplo 2")
            Text(text = "Ejemplo 3")

        }

    }

}


@Composable
fun MytriStatusCheckBox() {
    var status by rememberSaveable { mutableStateOf(ToggleableState.Off) }
    TriStateCheckbox(state = status, onClick = {
        status = when (status) {
            ToggleableState.On -> {
                ToggleableState.Off
            }

            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
        }
    })


}

@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {

    return titles.map {
        var status by rememberSaveable { mutableStateOf(false) }
        CheckInfo(
            title = it,
            selected = status,
            OncheckedChange = { status = it }//it es el Boolean
        )
    }


}


@Composable
fun MyChecBoxWithTextCompleted(checkInfo: CheckInfo) {


    Row(Modifier.padding(8.dp)) {
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = { checkInfo.OncheckedChange(!checkInfo.selected) })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = checkInfo.title)

    }
}


@Composable
fun MyChecBoxWithText() {
    var state by rememberSaveable { mutableStateOf(false) }

    Row(Modifier.padding(8.dp)) {
        Checkbox(checked = state, onCheckedChange = { state = !state })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Ejemplo 1")

    }
}


@Composable
fun MyChekBox() {
    var state by rememberSaveable { mutableStateOf(false) }

    Checkbox(
        checked = state, onCheckedChange = { state = !state },
        enabled = true,
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Red,
            uncheckedColor = Color.Green,
            checkmarkColor = Color.White


        )


    )


}

@Composable
fun MySwitch() {

    var state by rememberSaveable { mutableStateOf(false) }

    Switch(
        checked = state,
        onCheckedChange = { state = !state },
        enabled = true,
        colors = SwitchDefaults.colors(
            uncheckedThumbColor = Color.Red,
            checkedThumbColor = Color.Green,
            checkedTrackColor = Color.Cyan,
            uncheckedTrackColor = Color.Magenta,
            checkedTrackAlpha = 0.1f,
            uncheckedTrackAlpha = 0.1f,
            disabledCheckedTrackColor = Color.Yellow,
            disabledCheckedThumbColor = Color.Yellow,
            disabledUncheckedThumbColor = Color.Yellow,
            disabledUncheckedTrackColor = Color.Yellow

        )
    )


}

@Composable
fun MyProgressAdvance() {
    var progressStatus by rememberSaveable { mutableStateOf(0f) }




    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        // horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            Modifier
                .fillMaxWidth()
                .padding(0.dp, 30.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            LinearProgressIndicator(progress = progressStatus)

        }

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {


            Button(modifier = Modifier.padding(horizontal = 20.dp),


                onClick = {

                    if (progressStatus <= 0.99f) {

                        progressStatus += 0.1f
                    }
                }
            ) {
                Text(text = "Incrementar")
            }



            Button(onClick = {

                if (progressStatus >= 0.1f) {

                    progressStatus -= 0.1f
                }


            }) {
                Text(text = "Reducir")
            }


        }
    }
}


@Composable
fun MyProgress() {
    var showLoading by rememberSaveable { mutableStateOf(false) }
    Column(
        Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLoading) {

            CircularProgressIndicator(color = Color.Red, strokeWidth = 10.dp)
            LinearProgressIndicator(
                modifier = Modifier.padding(top = 32.dp),
                color = Color.Red,
                backgroundColor = Color.Green,
                strokeCap = StrokeCap.Square
            )
        }

        Button(onClick = { showLoading = !showLoading }) {
            Text(text = "Cargar perfil")

        }


    }


}


@Composable
fun MyIcon() {
    Icon(
        imageVector = Icons.Rounded.Star,
        contentDescription = "Icono",
        tint = Color.Red
    )
}

@Composable
fun MyImageAdvance() {
    Image(
        painter = painterResource(id = R.drawable.oja),
        contentDescription = "ejemplo",
        modifier = Modifier
            .clip(CircleShape)
            .border(10.dp, Color.Red, CircleShape)
    )
}

@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "ejemplo",
        alpha = 0.5f
    )

}


@Composable
fun MyButtonExample() {

    var enabled by rememberSaveable { mutableStateOf(true) }

    Column(
        Modifier
            .fillMaxSize()
        // .padding(2.dp)
    ) {
        Button(
            onClick = { enabled = false },
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta,
                contentColor = Color.White
            ),
            border = BorderStroke(3.dp, Color.Green)
        ) {
            Text(text = "Hola", color = Color.Green)
        }
        OutlinedButton(
            onClick = { enabled = false },
            enabled = enabled,
            modifier = Modifier.padding(top = 8.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Blue,
                contentColor = Color.White,
                disabledBackgroundColor = Color.Magenta,
                disabledContentColor = Color.Green
            )
        )

        {
            Text(text = "hola")

        }
        TextButton(onClick = {}) {
            Text(text = "Te veo", color = Color.Magenta)


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