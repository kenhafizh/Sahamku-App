package com.kenapps.sahamkuapp.trendingData

import com.google.gson.annotations.SerializedName


data class CompanyDetails(
    @SerializedName("symbol")
    var symbol: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("logo")
    var logo: String? = null,


)