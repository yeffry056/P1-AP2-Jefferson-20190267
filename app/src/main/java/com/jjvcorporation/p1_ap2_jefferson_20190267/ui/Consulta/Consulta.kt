package com.jjvcorporation.p1_ap2_jefferson_20190267.ui.Consulta

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Consulta(goRegistro: ()-> Unit){

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Consulta") })
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    goRegistro()
                },
                backgroundColor = MaterialTheme.colors.primary

            ) {
                Icon(imageVector = Icons.Default.Person, contentDescription = null)

            }
        },
        scaffoldState = scaffoldState
    ) {
        Column(modifier = Modifier
            .padding(it)
            .padding(8.dp)) {

            LazyColumn(modifier = Modifier.fillMaxWidth()){
                /*items(){

                }*/
            }

        }

    }

}

@Composable
fun RowList() {
    Row() {
        Text(text = "")
    }
}