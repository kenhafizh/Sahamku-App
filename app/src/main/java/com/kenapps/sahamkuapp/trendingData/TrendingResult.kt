package com.kenapps.sahamkuapp.trendingData

import com.google.gson.annotations.SerializedName
import java.io.Serial


data class TrendingResult(

  @SerializedName("symbol")
  var symbol: String? = null,
  @SerializedName("company")
  var company: CompanyDetails? = null,
  @SerializedName("name")
  var name: String? = null,
  @SerializedName("change")
  var change: String? = null,
  @SerializedName("percent")
  var percent: Double? = null
  )