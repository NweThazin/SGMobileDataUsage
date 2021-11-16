package com.sg.mytest.sgmobiledatausage.framework.di

import com.sg.mytest.sgmobiledatausage.data.repository.SGMobileRepository
import com.sg.mytest.sgmobiledatausage.domain.interactors.GetSGMobileDataUsageUseCase
import com.sg.mytest.sgmobiledatausage.domain.interactors.GetSGMobileDataUsageUseCaseImpl
import com.sg.mytest.sgmobiledatausage.domain.interactors.RetrieveCachedSGMobileDataUsageUseCase
import com.sg.mytest.sgmobiledatausage.domain.interactors.RetrieveCachedSGMobileDataUsageUseCaseImpl
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetSGMobileDataUsageUseCase(repository: SGMobileRepository): GetSGMobileDataUsageUseCase {
        return GetSGMobileDataUsageUseCaseImpl(repository)
    }

    @Provides
    fun provideRetrieveCachedSGMobileDataUsageUseCase(
        repository: SGMobileRepository
    ): RetrieveCachedSGMobileDataUsageUseCase {
        return RetrieveCachedSGMobileDataUsageUseCaseImpl(repository)
    }
}