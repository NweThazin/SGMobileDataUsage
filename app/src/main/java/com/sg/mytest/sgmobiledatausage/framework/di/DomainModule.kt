package com.sg.mytest.sgmobiledatausage.framework.di

import com.sg.mytest.sgmobiledatausage.data.repository.SGMobileRepository
import com.sg.mytest.sgmobiledatausage.domain.interactors.GetSGMobileDataUsageUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetSGMobileDataUsageUseCase(repository: SGMobileRepository): GetSGMobileDataUsageUseCase {
        return GetSGMobileDataUsageUseCase(repository)
    }
}