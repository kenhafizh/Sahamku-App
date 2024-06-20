package com.kenapps.sahamkuapp.newsData


import com.google.gson.annotations.SerializedName

data class NewsData(
    @SerializedName("data")
    var data: ResultWrapper,
    @SerializedName("message")
    var message: String?,
    @SerializedName("status")
    var status: String?
)