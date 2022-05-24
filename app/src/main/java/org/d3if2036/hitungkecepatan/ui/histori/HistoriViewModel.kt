package org.d3if2036.hitungkecepatan.ui.histori

import androidx.lifecycle.ViewModel
import org.d3if2036.hitungkecepatan.db.KecepatanDao

class HistoriViewModel(db: KecepatanDao) : ViewModel() {
    val data = db.getLastKecepatan()
}