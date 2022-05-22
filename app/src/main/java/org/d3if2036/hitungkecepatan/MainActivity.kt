package org.d3if2036.hitungkecepatan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import org.d3if2036.hitungkecepatan.databinding.ActivityMainBinding
import org.d3if2036.hitungkecepatan.model.HasilKecepatan

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener { hitungKec() }
        viewModel.getHasilKecepatan().observe(this, { showResult(it)})
    }
    private fun hitungKec() {
        val jarak = binding.jarakInp.text.toString()
        if (TextUtils.isEmpty(jarak)) {
            Toast.makeText(this, R.string.jarak_invalid, Toast.LENGTH_LONG).show()
                return
        }

        val waktu = binding.waktuInp.text.toString()
        if (TextUtils.isEmpty(waktu)) {
            Toast.makeText(this, R.string.waktu_invalid, Toast.LENGTH_LONG).show()
                return
        }

        viewModel.hitungKec(
            jarak.toFloat(),
            waktu.toFloat()
        )
    }

    private fun showResult(result: HasilKecepatan?){
        if (result == null) return
        binding.total.text = getString(R.string.hasilKecepatan, result.kecepatan)

    }
}