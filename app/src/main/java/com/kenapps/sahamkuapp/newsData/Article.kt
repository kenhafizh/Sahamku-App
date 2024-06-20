package com.kenapps.sahamkuapp.newsData


import com.google.gson.annotations.SerializedName

data class Article(
    @SerializedName("title")
    var title: String?,
    @SerializedName("published_at")
    var publishDate: String?,
    @SerializedName("image")
    var cover: String?,
    @SerializedName("url")
    var url: String?,
    @SerializedName("description")
    var description: String?,
    @SerializedName("publisher")
    var publisher: Publisher
)