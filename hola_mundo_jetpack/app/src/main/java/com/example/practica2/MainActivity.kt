package com.example.practica2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.practica2.ui.theme.Practica2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practica2Theme {
                    Greeting(
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }


@Composable
fun Greeting(modifier: Modifier = Modifier) {
    var texto_escrito_por_el_usuario = remember { mutableStateOf("Texto place holder")}
    var saludar_a = remember { mutableStateOf("mundo") }

    Column (
        modifier= modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
    Text(
        text = "Hello ${saludar_a.value}!",
        modifier = modifier
    )

    OutlinedTextField(
        value = texto_escrito_por_el_usuario.value,
        onValueChange = { texto_introducido_por_el_usuario ->
            texto_escrito_por_el_usuario.value = texto_introducido_por_el_usuario
        }
    )



    Button(
        onClick = {
            if (texto_escrito_por_el_usuario.value == ""){
                saludar_a.value = "mundo"
            }
            else {
                saludar_a.value = texto_escrito_por_el_usuario.value
                texto_escrito_por_el_usuario.value = ""
            }
        }
    ) {
        Text("PULSAME")
    }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Practica2Theme {
        //Greeting("Android")
    }
}