package com.kenapps.sahamkuapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kenapps.sahamkuapp.companiesData.Companies
import com.kenapps.sahamkuapp.companiesData.Results

import com.kenapps.sahamkuapp.databinding.SearchStockAdapterBinding
import com.kenapps.sahamkuapp.databinding.StockIndexAdapterBinding

open class SearchStockAdapter : RecyclerView.Adapter<SearchStockAdapter.StockViewHolder>() {

    var items = listOf<Results>()

    class StockViewHolder(val binding: SearchStockAdapterBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): SearchStockAdapter.StockViewHolder {
       val binding = SearchStockAdapterBinding.inflate(
           LayoutInflater.from(parent.context), parent, false
       )

        return StockViewHolder(binding)

    }

    override fun onBindViewHolder(holder: SearchStockAdapter.StockViewHolder, position: Int) {
        val items = items[position]


        Glide.with(holder.itemView.context)
            .load(items.logo)
            .into(holder.binding.logo)

        holder.binding.name.text = items.name
        holder.binding.symbol.text = items.symbol

    }

    override fun getItemCount(): Int {
        return items.size
    }
}