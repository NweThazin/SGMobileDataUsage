package com.sg.mytest.sgmobiledatausage.framework.network.model

import com.google.gson.annotations.SerializedName
import com.sg.mytest.sgmobiledatausage.domain.entities.Field
import com.sg.mytest.sgmobiledatausage.domain.entities.Record

data class SGMobileDataResult(
    @SerializedName("resource_id")
    val resourceId: String,
    @SerializedName("fields")
    val fields: List<Field>,
    @SerializedName("records")
    val records: List<Record>,
    @SerializedName("_links")
    val links: Map<String, String>,
    @SerializedName("total")
    val total: Int
)
