package com.jjvcorporation.p1_ap2_jefferson_20190267.util

sealed class Screen(val route: String) {
    object Registro: Screen("Registro")
    object Consulta: Screen("Consulta")
}