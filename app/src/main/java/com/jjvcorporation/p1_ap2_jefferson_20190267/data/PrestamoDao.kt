package com.jjvcorporation.p1_ap2_jefferson_20190267.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jjvcorporation.p1_ap2_jefferson_20190267.model.Prestamo
import kotlinx.coroutines.flow.Flow

@Dao
interface PrestamoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun Insertar(prestamo: Prestamo)

    @Query("SELECT * FROM Prestamos ORDER BY prestamoId")
    fun GetLista(): Flow<List<Prestamo>>
}