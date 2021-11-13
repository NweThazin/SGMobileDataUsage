package com.sg.mytest.sgmobiledatausage.data.datasource

import com.sg.mytest.sgmobiledatausage.framework.network.model.GetSGMobileDataUsageResponse
import retrofit2.Call
import retrofit2.http.GET

interface SGMobileDataSource {

    // todo: in progress - to add resource_id as param
    @GET("api/action/datastore_search?resource_id=a807b7ab-6cad-4aa6-87d0-e283a7353a0f")
    fun getSGMobileDataUsage(): Call<GetSGMobileDataUsageResponse>
}