package com.sg.mytest.sgmobiledatausage.framework.network.model

import com.google.gson.annotations.SerializedName

data class GetSGMobileDataUsageResponse(
    @SerializedName("help")
    val help: String,
    @SerializedName("success")
    val success: String
)
