package com.kenapps.sahamkuapp.stockDetails

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Shareholders(

    @SerializedName("amount")
    var amount: String? = null,
    @SerializedName("holding_type")
    var holdingType: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("percentage")
    var percentage: String? = null,
    @SerializedName("profile_id")
    var profileId: Int? = null,

    ) : Parcelable