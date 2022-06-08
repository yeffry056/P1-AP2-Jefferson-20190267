package com.jjvcorporation.p1_ap2_jefferson_20190267.ui.Registro

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jjvcorporation.p1_ap2_jefferson_20190267.ui.Prestamo.PrestamoViewModel

@Composable
fun Registro(
     viewModel : PrestamoViewModel = hiltViewModel()
) {
    val mContext = LocalContext.current
    val focusRequester1 = FocusRequester()
    val focusRequester2 = FocusRequester()
    val focusRequester3 = FocusRequester()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Prestamo")

                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {

                    if(viewModel.deudor == viewModel.limpiar){
                        focusRequester1.requestFocus()
                        Mensagge(mContext, "Deudor vacio")
                        return@FloatingActionButton
                    }
                    if(viewModel.concepto == viewModel.limpiar){
                        focusRequester2.requestFocus()
                        Mensagge(mContext, "concepto vacio")
                        return@FloatingActionButton
                    }
                    if(viewModel.monto == viewModel.limpiar){
                        focusRequester3.requestFocus()
                        Mensagge(mContext, "monto vacio")
                        return@FloatingActionButton
                    }

                    viewModel.Guardar()
                    viewModel.deudor = viewModel.limpiar
                    viewModel.concepto = viewModel.limpiar
                    viewModel.monto = viewModel.limpiar
                    focusRequester1.requestFocus()
                    Mensagge(mContext, "Guardado")

                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.Save, contentDescription = null)
            }
        }
    ) {
        Column(modifier = Modifier
            .padding(it)
            .padding(8.dp)) {

            OutlinedTextField(
                label = {
                    Text(text = "Deudor")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.PermIdentity, contentDescription = null)
                },
                value = viewModel.deudor,
                onValueChange = {viewModel.deudor = it},
                modifier = Modifier.fillMaxWidth().focusRequester(focusRequester1)

            )
            OutlinedTextField(
                label = {
                    Text(text = "Concepto")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Note, contentDescription = null)
                },
                value = viewModel.concepto,
                onValueChange = {viewModel.concepto = it},
                modifier = Modifier.fillMaxWidth().focusRequester(focusRequester2)

            )
            OutlinedTextField(
                label = {
                    Text(text = "Monto")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.MonetizationOn, contentDescription = null)
                },
                value = viewModel.monto,
                onValueChange = {viewModel.monto = it},
                modifier = Modifier.fillMaxWidth().focusRequester(focusRequester3)

            )
        }
    }

}

private fun Mensagge(context: Context, mensaje: String){
    Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show()
}
