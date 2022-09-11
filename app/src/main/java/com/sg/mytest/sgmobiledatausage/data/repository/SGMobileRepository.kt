package com.sg.mytest.sgmobiledatausage.data.repository

import com.sg.mytest.sgmobiledatausage.framework.database.entities.RecordEntity
import com.sg.mytest.sgmobiledatausage.framework.network.model.GetSGMobileDataUsageResponse
import retrofit2.Call

interface SGMobileRepository {

    fun getSGMobileDataUsage(resourceId: String): Call<GetSGMobileDataUsageResponse>

    suspend fun insertRecord(recordEntity: RecordEntity): Long

    suspend fun insertAllRecords(records: List<RecordEntity>): List<Long>

    suspend fun getAllRecords(): List<RecordEntity>

    suspend fun clearAll()
}