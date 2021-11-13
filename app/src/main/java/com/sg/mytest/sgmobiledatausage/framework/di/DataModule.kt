package com.sg.mytest.sgmobiledatausage.framework.di

import com.sg.mytest.sgmobiledatausage.data.datasource.SGMobileDataSource
import com.sg.mytest.sgmobiledatausage.data.repository.SGMobileRepository
import com.sg.mytest.sgmobiledatausage.data.repository.SGMobileRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideSGMobileRepository(dataSource: SGMobileDataSource): SGMobileRepository {
        return SGMobileRepositoryImpl(dataSource)
    }
}