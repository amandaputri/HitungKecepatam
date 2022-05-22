package org.d3if2036.hitungkecepatan

import androidx.lifecycle.ViewModel
import org.d3if2036.hitungkecepatan.model.HasilKecepatan

class MainViewModel : ViewModel (){
    fun hitungKec(jarak: Float, waktu:Float): HasilKecepatan {
        val hitungkecepatan = jarak / waktu
        return HasilKecepatan(hitungkecepatan)
    }
}