package com.sg.mytest.sgmobiledatausage.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MobileDataInfoByYear(
    val year: Int,
    val totalVolume: Double,
    val quarterlyRecord: List<Record>
) : Parcelable