package com.jjvcorporation.p1_ap2_jefferson_20190267.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jjvcorporation.p1_ap2_jefferson_20190267.model.Prestamo

@Database(
    entities = [
        Prestamo::class

    ],
    exportSchema = false,
    version = 1
)
abstract class PrestamosDb: RoomDatabase() {
    abstract val prestamoDao: PrestamoDao

}