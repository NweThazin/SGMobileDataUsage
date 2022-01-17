package com.sg.mytest.sgmobiledatausage.data.repository

import com.sg.mytest.sgmobiledatausage.data.datasource.SGMobileDataSource
import com.sg.mytest.sgmobiledatausage.framework.database.SGMobileDatabaseDao
import com.sg.mytest.sgmobiledatausage.framework.database.entities.RecordEntity
import com.sg.mytest.sgmobiledatausage.framework.network.model.GetSGMobileDataUsageResponse
import retrofit2.Call

class SGMobileRepositoryImpl(
    private val dataSource: SGMobileDataSource,
    private val dao: SGMobileDatabaseDao
) : SGMobileRepository {

    override fun getSGMobileDataUsage(resourceId: String): Call<GetSGMobileDataUsageResponse> {
        return dataSource.getSGMobileDataUsage(resourceId)
    }

    override suspend fun insertRecord(recordEntity: RecordEntity): Long {
        return dao.insertRecord(recordEntity)
    }

    override suspend fun insertAllRecords(records: List<RecordEntity>): List<Long> {
        return dao.insertAllRecords(records)
    }

    override suspend fun getAllRecords(): List<RecordEntity> {
        return dao.getAllRecords()
    }

    override suspend fun clearAll() {
        dao.clearAll()
    }

}