package org.d3if2036.hitungkecepatan.ui.hitung

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if2036.hitungkecepatan.db.KecepatanDao
import org.d3if2036.hitungkecepatan.db.KecepatanDb
import org.d3if2036.hitungkecepatan.db.KecepatanEntity
import org.d3if2036.hitungkecepatan.model.HasilKecepatan

class HitungViewModel(private val db: KecepatanDao): ViewModel (){

    private val hasilKecepatan = MutableLiveData<HasilKecepatan?>()

    fun hitungKec(jarak: Float, waktu:Float){
        val hitungkecepatan = jarak / waktu
        hasilKecepatan.value = HasilKecepatan(hitungkecepatan)

        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val dataKecepatan = KecepatanEntity(
                    jarak = jarak,
                    waktu = waktu
                )
                db.insert(dataKecepatan)
            }
        }
    }

    fun getHasilKecepatan(): LiveData<HasilKecepatan?> = hasilKecepatan
}