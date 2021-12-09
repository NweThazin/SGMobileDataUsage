package com.sg.mytest.sgmobiledatausage.framework.di

import com.sg.mytest.sgmobiledatausage.data.datasource.SGMobileDataSource
import com.sg.mytest.sgmobiledatausage.framework.network.SGMobileAPI
import com.sg.mytest.sgmobiledatausage.framework.network.SGMobileOkHttpClient
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit

val networkModule = module {
    fun provideOkHttpClient(): OkHttpClient {
        return SGMobileOkHttpClient.getOkHttpClient()
    }

    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return SGMobileAPI.getRetrofit(okHttpClient)
    }

    fun provideSGMobileDataSource(retrofit: Retrofit): SGMobileDataSource {
        return retrofit.create(SGMobileDataSource::class.java)
    }

    single { provideOkHttpClient() }
    single { provideRetrofit(get()) }
    single { provideSGMobileDataSource(get()) }
}