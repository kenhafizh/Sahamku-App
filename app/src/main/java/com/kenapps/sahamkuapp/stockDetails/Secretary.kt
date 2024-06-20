package com.kenapps.sahamkuapp.stockDetails

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Secretary (

  @SerializedName("email"        ) var email       : String? = null,
  @SerializedName("name"         ) var name        : String? = null,
  @SerializedName("phone_number" ) var phoneNumber : String? = null

) : Parcelable