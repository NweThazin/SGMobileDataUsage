package com.sg.mytest.sgmobiledatausage.data.repository

import com.sg.mytest.sgmobiledatausage.framework.network.model.GetSGMobileDataUsageResponse
import retrofit2.Call

interface SGMobileRepository {

    fun getSGMobileDataUsage(resourceId: String): Call<GetSGMobileDataUsageResponse>
}