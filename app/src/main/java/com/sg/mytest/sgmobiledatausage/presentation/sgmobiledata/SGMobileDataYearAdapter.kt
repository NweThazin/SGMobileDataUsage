package com.sg.mytest.sgmobiledatausage.presentation.sgmobiledata

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sg.mytest.sgmobiledatausage.databinding.ListItemMobileDataYearBinding

class SGMobileDataYearAdapter :
    RecyclerView.Adapter<SGMobileDataYearAdapter.SGMobileDataYearItemViewHolder>() {

    // todo - this is temp
    private var items = listOf<String>()
    fun setItems(list: List<String>) {
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

        // todo: temp to change data type and add more info to show
        fun bind(item: String) {
            binding.tvYear.text = item
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