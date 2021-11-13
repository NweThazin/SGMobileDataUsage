package com.sg.mytest.sgmobiledatausage.domain.entities

import com.google.gson.annotations.SerializedName

data class Record(
    @SerializedName("volume_of_mobile_data")
    val volumeOfMobileData: String,
    @SerializedName("quarter")
    val quarter: String,
    @SerializedName("_id")
    val id: Int
)
