package com.sg.mytest.sgmobiledatausage.domain.interactors

import com.sg.mytest.sgmobiledatausage.data.repository.SGMobileRepository
import com.sg.mytest.sgmobiledatausage.domain.entities.Record
import com.sg.mytest.sgmobiledatausage.framework.database.entities.asDomainModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

class RetrieveCachedSGMobileDataUsageUseCase(private val repository: SGMobileRepository) {
    suspend operator fun invoke(): List<Record> {
        return withContext(Dispatchers.IO) {
            try {
                val entities = repository.getAllRecords()
                return@withContext entities.asDomainModel()
            } catch (e: Exception) {
                Timber.e(e)
                return@withContext emptyList()
            }
        }
    }
}