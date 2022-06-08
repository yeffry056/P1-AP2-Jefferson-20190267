package com.jjvcorporation.p1_ap2_jefferson_20190267.ui.Consulta

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jjvcorporation.p1_ap2_jefferson_20190267.data.repository.prestamoRepository
import com.jjvcorporation.p1_ap2_jefferson_20190267.model.Prestamo
import com.jjvcorporation.p1_ap2_jefferson_20190267.ui.Prestamo.PrestamoViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun Consulta(
    goRegistro: ()-> Unit,
    viewModel : PrestamoViewModel = hiltViewModel()
){

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Listas de Prestamos") })
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    goRegistro()
                },
                backgroundColor = MaterialTheme.colors.primary

            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)

            }
        },
        scaffoldState = scaffoldState
    ) {
        Column(modifier = Modifier
            .padding(it)
            .padding(8.dp)) {

            val prestamoLis = viewModel.prestamos.collectAsState(initial = emptyList()).value
            LazyColumn( modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp)){
                items(prestamoLis){prestamo->
                    RowList(prestamo)
                }
            }

        }

    }

}

@Composable
fun RowList(prestamo: Prestamo) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(text = "Id: ${prestamo.prestamoId}")
        Text(text = "Deudor: ${prestamo.deudor}")
        Text(text = "Concepto: ${prestamo.concepto}")
        Text(text = "Monto: ${prestamo.monto}")


    }
}