package com.jjvcorporation.p1_ap2_jefferson_20190267.ui.Registro

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Registro() {

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Registro") })
        }
    ) {
        Column(modifier = Modifier.padding(it).padding(8.dp)) {

        }
    }

}
