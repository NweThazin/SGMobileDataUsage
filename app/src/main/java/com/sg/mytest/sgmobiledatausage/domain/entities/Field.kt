package com.sg.mytest.sgmobiledatausage.domain.entities

import com.google.gson.annotations.SerializedName

data class Field(
    @SerializedName("type")
    val type: String,
    @SerializedName("id")
    val id: String
)
