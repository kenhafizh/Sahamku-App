package com.kenapps.sahamkuapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kenapps.sahamkuapp.databinding.NewsAdapterBinding
import com.kenapps.sahamkuapp.newsData.Article


open class NewsAdapter() : RecyclerView.Adapter<NewsAdapter.IndexViewHolder>() {

    var items : List<Article> = emptyList()


    class IndexViewHolder (val binding: NewsAdapterBinding) : RecyclerView.ViewHolder(binding.root) {

    }

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
       val berita = items[position]


        Glide.with(holder.binding.root.context)
            .load(berita.cover)
            .into(holder.binding.logo)

        holder.binding.newsTitle.text = berita.title
        holder.binding.newsDate.text = berita.publishDate

    }

    override fun getItemCount(): Int {
        return items.size
    }


}