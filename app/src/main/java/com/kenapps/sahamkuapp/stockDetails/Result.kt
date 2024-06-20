package com.kenapps.sahamkuapp.stockDetails

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Result(

  @SerializedName("symbol")
  var symbol: String? = null,
  @SerializedName("name")
  var name: String? = null,
  @SerializedName("about")
  var about: String? = null,
  @SerializedName("logo")
  var logo: String? = null,
  @SerializedName("npwp")
  var npwp: String? = null,
  @SerializedName("phone")
  var phone: String? = null,
  @SerializedName("fax")
  var fax: String? = null,
  @SerializedName("email")
  var email: String? = null,
  @SerializedName("sector_name")
  var sectorName: String? = null,
  @SerializedName("status")
  var status: String? = null,
  @SerializedName("sub_industry_name")
  var subIndustryName: String? = null,
  @SerializedName("sub_sector_name")
  var subSectorName: String? = null,
  @SerializedName("website")
  var website: String? = null,
  @SerializedName("address")
  var address: String? = null,
  @SerializedName("ipo_fund_raised")
  var ipoFundRaised: Long? = null,
  @SerializedName("ipo_listing_date")
  var ipoListingDate: String? = null,
  @SerializedName("ipo_offering_shares")
  var ipoOfferingShares: Int? = null,
  @SerializedName("ipo_percentage")
  var ipoPercentage: Double? = null,
  @SerializedName("ipo_securities_administration_bureau")
  var ipoSecuritiesAdministrationBureau: String? = null,
  @SerializedName("ipo_total_listed_shares")
  var ipoTotalListedShares: Long? = null,
  @SerializedName("ipo_founders_shares")
  var ipoFoundersShares: Long? = null,
  @SerializedName("secretary")
  var secretary: ArrayList<Secretary> = arrayListOf(),
  @SerializedName("commissioners")
  var commissioners: ArrayList<Commissioners> = arrayListOf(),
  @SerializedName("directors")
  var directors: ArrayList<Directors> = arrayListOf(),
  @SerializedName("shareholders")
  var shareholders: ArrayList<Shareholders> = arrayListOf(),

  ) : Parcelable