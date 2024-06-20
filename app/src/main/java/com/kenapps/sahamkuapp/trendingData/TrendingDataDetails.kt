package com.kenapps.sahamkuapp.trendingData

import com.google.gson.annotations.SerializedName


data class TrendingDataDetails(

  @SerializedName("results")
  var results: List<TrendingResult> = listOf()
)