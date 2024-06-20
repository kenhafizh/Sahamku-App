package com.kenapps.sahamkuapp.stockDetails

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Directors(

    @SerializedName("affiliated")
    var affiliated: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("profile_id")
    var profileId: Int? = null,
    @SerializedName("role")
    var role: String? = null,

    ) : Parcelable