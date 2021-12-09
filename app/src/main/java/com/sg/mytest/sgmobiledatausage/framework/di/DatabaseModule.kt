package com.sg.mytest.sgmobiledatausage.framework.di

import android.content.Context
import com.sg.mytest.sgmobiledatausage.framework.database.SGMobileDatabaseDao
import com.sg.mytest.sgmobiledatausage.framework.database.SGMobileUsageDatabase
import org.koin.dsl.module

val databaseModule = module {
    fun provideSGMobileUsageDatabase(context: Context): SGMobileDatabaseDao {
        return SGMobileUsageDatabase.getInstance(context).databaseDao
    }

    single { provideSGMobileUsageDatabase(get()) }
}