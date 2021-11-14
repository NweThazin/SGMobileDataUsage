package com.sg.mytest.sgmobiledatausage.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TotalVolumeByYear(
    val year: Int,
    val totalVolume: Double
) : Parcelable