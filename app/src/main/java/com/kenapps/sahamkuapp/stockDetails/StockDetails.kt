package com.kenapps.sahamkuapp.stockDetails

import com.google.gson.annotations.SerializedName


data class StockDetails (

  @SerializedName("status"  )
  var status  : String?  = null,
  @SerializedName("message" )
  var message : String?  = null,
  @SerializedName("data" )
  var result : Result? = null

)