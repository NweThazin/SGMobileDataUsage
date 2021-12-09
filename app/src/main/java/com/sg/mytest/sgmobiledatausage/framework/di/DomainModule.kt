package com.sg.mytest.sgmobiledatausage.framework.di

import com.sg.mytest.sgmobiledatausage.data.repository.SGMobileRepository
import com.sg.mytest.sgmobiledatausage.domain.interactors.GetSGMobileDataUsageUseCase
import com.sg.mytest.sgmobiledatausage.domain.interactors.GetSGMobileDataUsageUseCaseImpl
import com.sg.mytest.sgmobiledatausage.domain.interactors.RetrieveCachedSGMobileDataUsageUseCase
import com.sg.mytest.sgmobiledatausage.domain.interactors.RetrieveCachedSGMobileDataUsageUseCaseImpl
import org.koin.dsl.module

val domainModule = module {

    fun provideGetSGMobileDataUsageUseCase(
        repository: SGMobileRepository
    ): GetSGMobileDataUsageUseCase {
        return GetSGMobileDataUsageUseCaseImpl(repository)
    }

    fun provideRetrieveCachedSGMobileDataUsageUseCase(
        repository: SGMobileRepository
    ): RetrieveCachedSGMobileDataUsageUseCase {
        return RetrieveCachedSGMobileDataUsageUseCaseImpl(repository)
    }

    single { provideGetSGMobileDataUsageUseCase(get()) }
    single { provideRetrieveCachedSGMobileDataUsageUseCase(get()) }
}