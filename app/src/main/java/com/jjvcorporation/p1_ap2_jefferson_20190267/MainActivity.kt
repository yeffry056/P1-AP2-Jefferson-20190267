package com.jjvcorporation.p1_ap2_jefferson_20190267

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jjvcorporation.p1_ap2_jefferson_20190267.ui.Componentes.Screen
import com.jjvcorporation.p1_ap2_jefferson_20190267.ui.Consulta.Consulta
import com.jjvcorporation.p1_ap2_jefferson_20190267.ui.Registro.Registro
import com.jjvcorporation.p1_ap2_jefferson_20190267.ui.theme.P1AP2Jefferson20190267Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            P1AP2Jefferson20190267Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
   val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = Screen.Consulta.route){
        composable(route = Screen.Consulta.route){
            Consulta (goRegistro = {navHostController.navigate(Screen.Registro.route)})
        }
        composable(route = Screen.Registro.route){
            Registro()
        }


    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    P1AP2Jefferson20190267Theme {
        MyApp()
    }
}