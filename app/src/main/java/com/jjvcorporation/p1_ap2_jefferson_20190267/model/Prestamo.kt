package com.jjvcorporation.p1_ap2_jefferson_20190267.model

import androidx.room.Entity

@Entity(tableName = "Prestamos")
data class Prestamo(
    val prestamoId: Int =0,
    val deudor: String,
    val concepto : String,
    val monto: Double
)
