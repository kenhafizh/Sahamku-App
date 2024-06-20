package com.kenapps.sahamkuapp.companiesData

import com.google.gson.annotations.SerializedName


data class DataResponse(

  @SerializedName("count")
  var count: Int? = null,
  @SerializedName("results")
  var results: ArrayList<Results> = arrayListOf(),

  )