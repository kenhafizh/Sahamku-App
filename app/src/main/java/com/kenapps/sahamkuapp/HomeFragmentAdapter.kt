package com.kenapps.sahamkuapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kenapps.sahamkuapp.companiesData.Results
import com.kenapps.sahamkuapp.databinding.FragmentHomeAdapterBinding
import com.kenapps.sahamkuapp.trendingData.CompanyDetails
import com.kenapps.sahamkuapp.trendingData.TrendingData
import com.kenapps.sahamkuapp.trendingData.TrendingDataDetails
import com.kenapps.sahamkuapp.trendingData.TrendingResult


class HomeFragmentAdapter() : RecyclerView.Adapter<HomeFragmentAdapter.HomeViewHolder>() {

    var trend = listOf<TrendingResult>()

    class HomeViewHolder (val binding: FragmentHomeAdapterBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): HomeFragmentAdapter.HomeViewHolder {
        val binding = FragmentHomeAdapterBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeFragmentAdapter.HomeViewHolder, position: Int) {
       val trend = trend[position]

        Glide.with(holder.itemView.context)
            .load(trend.company!!.logo)
            .into(holder.binding.logo)

        holder.binding.name.text = trend.company!!.name
        holder.binding.symbol.text = trend.symbol

    }

    override fun getItemCount(): Int {
        return trend.size
    }


}