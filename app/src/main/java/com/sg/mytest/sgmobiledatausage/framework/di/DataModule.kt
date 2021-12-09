package com.sg.mytest.sgmobiledatausage.framework.di

import com.sg.mytest.sgmobiledatausage.data.datasource.SGMobileDataSource
import com.sg.mytest.sgmobiledatausage.data.repository.SGMobileRepository
import com.sg.mytest.sgmobiledatausage.data.repository.SGMobileRepositoryImpl
import com.sg.mytest.sgmobiledatausage.framework.database.SGMobileDatabaseDao
import org.koin.dsl.module

val dataModule = module {
    fun provideSGMobileRepository(
        dataSource: SGMobileDataSource,
        dao: SGMobileDatabaseDao
    ): SGMobileRepository {
        return SGMobileRepositoryImpl(dataSource, dao)
    }

    single { provideSGMobileRepository(get(), get()) }
}