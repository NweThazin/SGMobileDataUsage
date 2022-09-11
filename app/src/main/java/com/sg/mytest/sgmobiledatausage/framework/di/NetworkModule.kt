package com.sg.mytest.sgmobiledatausage.framework.di

import com.sg.mytest.sgmobiledatausage.data.datasource.SGMobileDataSource
import com.sg.mytest.sgmobiledatausage.framework.network.SGMobileAPI
import com.sg.mytest.sgmobiledatausage.framework.network.SGMobileOkHttpClient
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return SGMobileOkHttpClient.getOkHttpClient()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return SGMobileAPI.getRetrofit(okHttpClient)
    }

    @Singleton
    @Provides
    fun provideSGMobileDataSource(retrofit: Retrofit): SGMobileDataSource {
        return retrofit.create(SGMobileDataSource::class.java)
    }
}