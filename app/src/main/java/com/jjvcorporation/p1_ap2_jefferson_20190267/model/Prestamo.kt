package com.jjvcorporation.p1_ap2_jefferson_20190267.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Prestamos")
data class Prestamo(
    @PrimaryKey(autoGenerate = true)
    val prestamoId: Int =0,
    val deudor: String,
    val concepto : String,
    val monto: Double
)
