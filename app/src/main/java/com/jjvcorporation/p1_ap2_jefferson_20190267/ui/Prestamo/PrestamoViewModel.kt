package com.jjvcorporation.p1_ap2_jefferson_20190267.ui.Prestamo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jjvcorporation.p1_ap2_jefferson_20190267.data.repository.prestamoRepository
import com.jjvcorporation.p1_ap2_jefferson_20190267.model.Prestamo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PrestamoViewModel @Inject constructor(
    val prestamoRepository: prestamoRepository
): ViewModel(){

    var deudor by mutableStateOf("")
    var concepto by mutableStateOf("")
    var monto by mutableStateOf("")
    var limpiar by mutableStateOf("")

    var prestamos = prestamoRepository.GetLista()
    private set

    fun Guardar(){
        viewModelScope.launch{
            prestamoRepository.Insertar(
                Prestamo(
                    deudor = deudor,
                    concepto = concepto,
                    monto = monto.toDouble()

                )
            )
        }
    }
}