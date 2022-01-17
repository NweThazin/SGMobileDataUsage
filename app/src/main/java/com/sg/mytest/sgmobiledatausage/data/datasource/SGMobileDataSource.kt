package com.sg.mytest.sgmobiledatausage.data.datasource

import com.sg.mytest.sgmobiledatausage.framework.network.model.GetSGMobileDataUsageResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SGMobileDataSource {

    @GET("api/action/datastore_search")
    fun getSGMobileDataUsage(@Query("resource_id") resourceId: String): Call<GetSGMobileDataUsageResponse>
}