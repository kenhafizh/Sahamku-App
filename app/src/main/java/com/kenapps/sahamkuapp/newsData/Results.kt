package com.kenapps.sahamkuapp.newsData


import com.google.gson.annotations.SerializedName

data class Results(
    @SerializedName("cover")
    var cover: String?,
    @SerializedName("description")
    var description: String?,
    @SerializedName("publish_date")
    var publishDate: String?,
    @SerializedName("title")
    var title: String?,
    @SerializedName("url")
    var url: String?
)