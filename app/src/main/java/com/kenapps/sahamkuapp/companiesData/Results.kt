package com.kenapps.sahamkuapp.companiesData

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class  Results(

  @SerializedName("symbol")
  var symbol: String? = null,
  @SerializedName("name")
  var name: String? = null,
  @SerializedName("logo")
  var logo: String? = null,

  ) : Parcelable