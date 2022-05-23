package org.d3if2036.hitungkecepatan.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.d3if2036.hitungkecepatan.model.HasilKecepatan

class MainViewModel : ViewModel (){

    private val hasilKecepatan = MutableLiveData<HasilKecepatan?>()

    fun hitungKec(jarak: Float, waktu:Float){
        val hitungkecepatan = jarak / waktu
        hasilKecepatan.value = HasilKecepatan(hitungkecepatan)
    }

    fun getHasilKecepatan(): LiveData<HasilKecepatan?> = hasilKecepatan
}