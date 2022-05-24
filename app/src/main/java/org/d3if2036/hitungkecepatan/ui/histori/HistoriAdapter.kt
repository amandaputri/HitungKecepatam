package org.d3if2036.hitungkecepatan.ui.histori

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.d3if2036.hitungkecepatan.R
import org.d3if2036.hitungkecepatan.databinding.ItemHistoriBinding
import org.d3if2036.hitungkecepatan.db.KecepatanEntity
import org.d3if2036.hitungkecepatan.model.hitungKec
import java.text.SimpleDateFormat
import java.util.*

class HistoriAdapter :
    ListAdapter<KecepatanEntity, HistoriAdapter.ViewHolder>(DIFF_CALLBACK){

    companion object{
        private val DIFF_CALLBACK =
            object : DiffUtil.ItemCallback<KecepatanEntity>(){
                override fun areItemsTheSame(
                    oldItem: KecepatanEntity,
                    newItem: KecepatanEntity
                ): Boolean {
                    return oldItem.id == newItem.id
                }

                @SuppressLint("DiffUtilEquals")
                override fun areContentsTheSame(
                    oldItem: KecepatanEntity,
                    newItem: KecepatanEntity
                ): Boolean {
                    return oldItem == newItem
                }
            }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHistoriBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class ViewHolder(
        private val binding: ItemHistoriBinding
    ) : RecyclerView.ViewHolder(binding.root){
        private val dateFormatter = SimpleDateFormat("dd MMMM yyyy",
            Locale("id", "ID")
        )

        fun bind(item: KecepatanEntity) = with(binding) {
            val hasilKecepatan = item.hitungKec()

            tanggal.text = dateFormatter.format(Date(item.tanggal))
            kecepatan.text = root.context.getString(R.string.hasil_x, hasilKecepatan.kecepatan)
            dataTextView.text = root.context.getString(R.string.data_x, item.jarak, item.waktu)
        }
    }
}