package com.sg.mytest.sgmobiledatausage

import android.content.Context
import com.google.gson.Gson
import com.sg.mytest.sgmobiledatausage.domain.interactors.GetSGMobileDataUsageUseCase
import com.sg.mytest.sgmobiledatausage.framework.network.model.GetSGMobileDataUsageResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.lang.Exception

class FakeGetSGMobileDataUsageUseCaseImpl(private val context: Context) :
    GetSGMobileDataUsageUseCase {
    override suspend fun invoke(): Result<GetSGMobileDataUsageResponse> {
        return withContext(Dispatchers.IO) {
            try {
                val result = loadMockData(context)
                return@withContext Result.success(result)
            } catch (ex: Exception) {
                Timber.e(ex)
                return@withContext Result.failure(ex)
            }
        }
    }

    private fun loadMockData(context: Context): GetSGMobileDataUsageResponse {
        val jsonString = context.resources.openRawResource(R.raw.mock_test_get_sg_mobile)
            .bufferedReader().use { it.readText() }
        return Gson().fromJson(jsonString, GetSGMobileDataUsageResponse::class.java)
    }
}