package com.sg.mytest.sgmobiledatausage.framework.network

import com.sg.mytest.sgmobiledatausage.util.AppConstants.DEFAULT_SERVER_TIMEOUT
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

object SGMobileOkHttpClient {

    fun getOkHttpClient(): OkHttpClient {
        val builder = getOkHttpClientBuilder()
        builder.addInterceptor(getHttpLoggingInterceptor())
        builder.addNetworkInterceptor(getHttpLoggingInterceptor())
        return builder.build()
    }

    private fun getOkHttpClientBuilder(): OkHttpClient.Builder {
        val builder = OkHttpClient.Builder().apply {
            connectTimeout(DEFAULT_SERVER_TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(DEFAULT_SERVER_TIMEOUT, TimeUnit.SECONDS)
            readTimeout(DEFAULT_SERVER_TIMEOUT, TimeUnit.SECONDS)
        }
        return builder
    }

    private fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }
}