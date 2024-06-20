package com.kenapps.sahamkuapp.companiesData

import com.google.gson.annotations.SerializedName


data class Companies(

  @SerializedName("status")
  var status: String? = null,
  @SerializedName("message")
  var message: String? = null,
  @SerializedName("data")
  var dataResponse: DataResponse? = DataResponse(),

  )