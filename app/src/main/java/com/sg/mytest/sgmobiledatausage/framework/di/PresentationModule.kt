package com.sg.mytest.sgmobiledatausage.framework.di

import android.app.Application
import com.sg.mytest.sgmobiledatausage.domain.interactors.GetSGMobileDataUsageUseCase
import com.sg.mytest.sgmobiledatausage.domain.interactors.RetrieveCachedSGMobileDataUsageUseCase
import com.sg.mytest.sgmobiledatausage.presentation.sgmobiledata.SGMobileDataUsageViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class PresentationModule {

    //region Factory
    @Provides
    fun provideSGMobileDataUsageViewModelFactory(
        application: Application,
        useCase: GetSGMobileDataUsageUseCase,
        localUseCase: RetrieveCachedSGMobileDataUsageUseCase
    ): SGMobileDataUsageViewModelFactory {
        return SGMobileDataUsageViewModelFactory(application, useCase, localUseCase)
    }

    //endregion
}