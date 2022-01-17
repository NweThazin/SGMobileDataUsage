package com.sg.mytest.sgmobiledatausage.framework.di

import android.content.Context
import com.sg.mytest.sgmobiledatausage.framework.database.SGMobileDatabaseDao
import com.sg.mytest.sgmobiledatausage.framework.database.SGMobileUsageDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideSGMobileUsageDatabase(context: Context): SGMobileDatabaseDao {
        return SGMobileUsageDatabase.getInstance(context).databaseDao
    }
}