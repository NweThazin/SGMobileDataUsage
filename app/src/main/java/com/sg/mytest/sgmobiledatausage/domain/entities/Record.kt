package com.sg.mytest.sgmobiledatausage.domain.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Record(
    @SerializedName("volume_of_mobile_data")
    val volumeOfMobileData: String,
    @SerializedName("quarter")
    val quarter: String,
    @SerializedName("_id")
    val id: Int
) : Parcelable {
    fun getMobileDataYear(): String {
        return quarter.substringBefore("-")
    }
}
