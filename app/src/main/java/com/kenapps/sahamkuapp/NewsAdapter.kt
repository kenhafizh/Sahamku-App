package com.kenapps.sahamkuapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kenapps.sahamkuapp.companiesData.Results
import com.kenapps.sahamkuapp.databinding.NewsAdapterBinding
import com.kenapps.sahamkuapp.databinding.StockIndexAdapterBinding

import com.kenapps.sahamkuapp.newsData.NewsData


open class NewsAdapter() : RecyclerView.Adapter<NewsAdapter.IndexViewHolder>() {

    var items = listOf<com.kenapps.sahamkuapp.newsData.Results>()


    class IndexViewHolder (val binding: NewsAdapterBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): NewsAdapter.IndexViewHolder {
        val binding = NewsAdapterBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return IndexViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsAdapter.IndexViewHolder, position: Int) {
       val items = items[position]


        Glide.with(holder.itemView.context)
            .load(items.cover)
            .into(holder.binding.logo)

        holder.binding.newsTitle.text = items.title
        holder.binding.newsDate.text = items.publishDate
        holder.binding.newsDesc.text = items.description

    }

    override fun getItemCount(): Int {
        return items.size
    }


}