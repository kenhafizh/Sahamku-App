package com.kenapps.sahamkuapp.trendingData

import com.google.gson.annotations.SerializedName


data class TrendingData(

  @SerializedName("status")
  var status: String? = null,
  @SerializedName("message")
  var message: String? = null,
  @SerializedName("data")
  var data: TrendingDataDetails? = null
)