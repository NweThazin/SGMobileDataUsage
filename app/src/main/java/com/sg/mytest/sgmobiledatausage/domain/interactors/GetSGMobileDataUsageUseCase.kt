package com.sg.mytest.sgmobiledatausage.domain.interactors

import kotlinx.coroutines.withContext
import com.sg.mytest.sgmobiledatausage.data.repository.SGMobileRepository
import com.sg.mytest.sgmobiledatausage.framework.network.model.GetSGMobileDataUsageResponse
import kotlinx.coroutines.Dispatchers
import retrofit2.await
import timber.log.Timber
import java.lang.Exception

class GetSGMobileDataUsageUseCase(private val repository: SGMobileRepository) {
    suspend operator fun invoke(): Result<GetSGMobileDataUsageResponse> {
        return withContext(Dispatchers.IO) {
            try {
                val resourceId = "a807b7ab-6cad-4aa6-87d0-e283a7353a0f"
                val result = repository.getSGMobileDataUsage(resourceId).await()
                Timber.d(result.toString())
                return@withContext Result.success(result)
            } catch (ex: Exception) {
                Timber.e(ex)
                return@withContext Result.failure(ex)
            }
        }
    }
}