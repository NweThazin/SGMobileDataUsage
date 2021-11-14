package com.sg.mytest.sgmobiledatausage.presentation.sgmobiledata.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sg.mytest.sgmobiledatausage.databinding.ListItemMobileDataYearBinding
import com.sg.mytest.sgmobiledatausage.domain.entities.TotalVolumeByYear

class SGMobileDataYearAdapter(val listener: SGMobileDataYearListener) :
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
        return SGMobileDataYearItemViewHolder.from(parent, listener)
    }

    override fun onBindViewHolder(holder: SGMobileDataYearItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.count()

    class SGMobileDataYearItemViewHolder(
        private val binding: ListItemMobileDataYearBinding,
        private val listener: SGMobileDataYearListener
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TotalVolumeByYear) {
            binding.tvYear.text = item.year.toString()
            binding.tvDataVolume.text = item.totalVolume.toString()
            binding.root.setOnClickListener {
                listener.onClickItem(item)
            }
        }

        companion object {
            fun from(
                parent: ViewGroup,
                listener: SGMobileDataYearListener
            ): SGMobileDataYearItemViewHolder {
                return SGMobileDataYearItemViewHolder(
                    ListItemMobileDataYearBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ),
                    listener
                )
            }
        }
    }

}