package com.kenapps.sahamkuapp.newsData


import com.google.gson.annotations.SerializedName

data class NewsData(
    @SerializedName("data")
//    val data: List<Data?>?,
    var data: List<Results> = listOf(),
    @SerializedName("message")
    var message: String?,
    @SerializedName("status")
    var status: String?
)