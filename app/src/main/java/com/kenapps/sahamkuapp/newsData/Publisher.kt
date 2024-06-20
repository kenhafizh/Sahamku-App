package com.kenapps.sahamkuapp.newsData

import com.google.gson.annotations.SerializedName

data class Publisher (
    @SerializedName("name")
    var name: String?,
    @SerializedName("logo")
    var logo: String?,
)
