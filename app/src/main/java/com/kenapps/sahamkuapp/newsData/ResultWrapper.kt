package com.kenapps.sahamkuapp.newsData

import com.google.gson.annotations.SerializedName

data class ResultWrapper(

    @SerializedName("results")
    var results: List<Article>
)
