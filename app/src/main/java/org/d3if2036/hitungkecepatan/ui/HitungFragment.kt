package org.d3if2036.hitungkecepatan.ui

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.d3if2036.hitungkecepatan.R
import org.d3if2036.hitungkecepatan.databinding.FragmentHitungBinding
import org.d3if2036.hitungkecepatan.model.HasilKecepatan

class HitungFragment : Fragment() {

    private lateinit var binding: FragmentHitungBinding
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(requireActivity())[MainViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHitungBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.button.setOnClickListener { hitungKec() }
        viewModel.getHasilKecepatan().observe(requireActivity(), {showResult(it)})
    }

    private fun hitungKec() {
        val jarak = binding.jarakInp.text.toString()
        if (TextUtils.isEmpty(jarak)) {
            Toast.makeText(context, R.string.jarak_invalid, Toast.LENGTH_LONG).show()
                return
        }

        val waktu = binding.waktuInp.text.toString()
        if (TextUtils.isEmpty(waktu)) {
            Toast.makeText(context, R.string.waktu_invalid, Toast.LENGTH_LONG).show()
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