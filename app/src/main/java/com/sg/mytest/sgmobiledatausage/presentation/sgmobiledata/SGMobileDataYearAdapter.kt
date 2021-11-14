package com.sg.mytest.sgmobiledatausage.presentation.sgmobiledata

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sg.mytest.sgmobiledatausage.databinding.ListItemMobileDataYearBinding
import com.sg.mytest.sgmobiledatausage.domain.entities.TotalVolumeByYear

class SGMobileDataYearAdapter :
    RecyclerView.Adapter<SGMobileDataYearAdapter.SGMobileDataYearItemViewHolder>() {

    private var items = listOf<TotalVolumeByYear>()
    fun setItems(list: List<TotalVolumeByYear>) {
        items = list
        notifyItemRangeChanged(0, list.size)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SGMobileDataYearItemViewHolder {
        return SGMobileDataYearItemViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: SGMobileDataYearItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.count()

    class SGMobileDataYearItemViewHolder(private val binding: ListItemMobileDataYearBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TotalVolumeByYear) {
            binding.tvYear.text = item.year.toString()
            binding.tvDataVolume.text = item.totalVolume.toString()
            binding.root.setOnClickListener {
                // todo : to enable click event
                println(item)
            }
        }

        companion object {
            fun from(parent: ViewGroup): SGMobileDataYearItemViewHolder {
                return SGMobileDataYearItemViewHolder(
                    ListItemMobileDataYearBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }

}