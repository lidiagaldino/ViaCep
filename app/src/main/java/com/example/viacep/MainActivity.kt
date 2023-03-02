package com.example.viacep

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.viacep.service.BuscarCep
import com.example.viacep.ui.theme.ViaCepTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViaCepTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {

    var cep by remember {
        mutableStateOf("")
    }
    var resultState by remember {
        mutableStateOf("")
    }

    var cepError by remember {
        mutableStateOf(false)
    }

    Column(modifier = Modifier.fillMaxSize()) {

        Text(text = "Digite um cep")

        OutlinedTextField(value = cep, onValueChange = {newCep->
            val lastChar =if(newCep.isEmpty()){
                cepError = true
                newCep
            }else{
                cepError = false
                newCep[newCep.length -1]
            }

            val finalId =if (lastChar == '.' || lastChar == '/' || lastChar == '?') newCep.dropLast(1) else newCep

            cep =finalId
        })

        Button(onClick = { resultState = BuscarCep(cep) { logradouro, numero ->
            resultState = logradouro
        }.toString()
        }) {
            Text(text = "Buscar")
        }

        Text(text = resultState)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ViaCepTheme {
        Greeting("Android")
    }
}