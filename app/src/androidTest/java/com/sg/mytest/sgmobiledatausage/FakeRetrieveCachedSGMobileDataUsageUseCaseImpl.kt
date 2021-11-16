package com.sg.mytest.sgmobiledatausage

import com.sg.mytest.sgmobiledatausage.domain.entities.Record
import com.sg.mytest.sgmobiledatausage.domain.interactors.RetrieveCachedSGMobileDataUsageUseCase
import com.sg.mytest.sgmobiledatausage.framework.database.entities.RecordEntity
import com.sg.mytest.sgmobiledatausage.framework.database.entities.asDomainModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.lang.Exception

class FakeRetrieveCachedSGMobileDataUsageUseCaseImpl : RetrieveCachedSGMobileDataUsageUseCase {
    override suspend fun invoke(): List<Record> {
        return withContext(Dispatchers.IO) {
            try {
                val records = listOf(
                    RecordEntity("0.000384", "2010-Q3", 1),
                    RecordEntity("0.000543", "2010-Q4", 2),
                    RecordEntity("0.000543", "2011-Q1", 3),
                    RecordEntity("0.000634", "2011-Q2", 4),
                    RecordEntity("0.000634", "2011-Q3", 5)
                )
                return@withContext records.asDomainModel()
            } catch (ex: Exception) {
                Timber.e(ex)
                return@withContext emptyList()
            }
        }
    }
}