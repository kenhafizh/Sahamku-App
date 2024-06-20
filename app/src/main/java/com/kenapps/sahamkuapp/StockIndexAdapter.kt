package com.kenapps.sahamkuapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kenapps.sahamkuapp.companiesData.Results
import com.kenapps.sahamkuapp.databinding.StockIndexAdapterBinding


class StockIndexAdapter(val listener: onStockClickListener) : RecyclerView.Adapter<StockIndexAdapter.IndexViewHolder>() {

    var items = listOf<Results>()

    interface onStockClickListener {
        fun onClick(stock: Results, Index: Int)
    }

    class IndexViewHolder (val binding: StockIndexAdapterBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): StockIndexAdapter.IndexViewHolder {
        val binding = StockIndexAdapterBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return IndexViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StockIndexAdapter.IndexViewHolder, position: Int) {
       val items = items[position]


        Glide.with(holder.itemView.context)
            .load(items.logo)
            .into(holder.binding.logo)

        holder.binding.name.text = items.name
        holder.binding.symbol.text = items.symbol

        holder.binding.root.setOnClickListener {
            listener.onClick(items, position)
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }


}