package com.sg.mytest.sgmobiledatausage.data.repository

import com.sg.mytest.sgmobiledatausage.data.datasource.SGMobileDataSource
import com.sg.mytest.sgmobiledatausage.framework.network.model.GetSGMobileDataUsageResponse
import retrofit2.Call

class SGMobileRepositoryImpl(private val dataSource: SGMobileDataSource) : SGMobileRepository {

    override fun getSGMobileDataUsage(resourceId: String): Call<GetSGMobileDataUsageResponse> {
        return dataSource.getSGMobileDataUsage(resourceId)
    }
}