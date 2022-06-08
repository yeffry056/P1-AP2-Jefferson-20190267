package com.jjvcorporation.p1_ap2_jefferson_20190267.data.repository

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jjvcorporation.p1_ap2_jefferson_20190267.data.PrestamoDao
import com.jjvcorporation.p1_ap2_jefferson_20190267.model.Prestamo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class prestamoRepository @Inject constructor(
    val prestamoDao: PrestamoDao
){

    suspend fun Insertar(prestamo: Prestamo){
        prestamoDao.Insertar(prestamo)
    }


    fun GetLista(): Flow<List<Prestamo>>{
        return prestamoDao.GetLista()
    }
}