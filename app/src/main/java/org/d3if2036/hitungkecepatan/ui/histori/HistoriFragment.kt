package org.d3if2036.hitungkecepatan.ui.histori

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.d3if2036.hitungkecepatan.databinding.FragmentHistoriBinding
import org.d3if2036.hitungkecepatan.db.KecepatanDb
import org.d3if2036.hitungkecepatan.model.HistoriViewModel

class HistoriFragment : Fragment() {

    private lateinit var binding: FragmentHistoriBinding

    private val viewModel: HistoriViewModel by lazy {
        val db = KecepatanDb.getInstance(requireContext())
        val factory = HistoriViewModelFactory(db.dao)
        ViewModelProvider(this, factory)[HistoriViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoriBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.data.observe(viewLifecycleOwner,{
            Log.d("HistoriFragment", "Jumlah data: ${it.size}")
        })
    }
}