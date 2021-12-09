package com.sg.mytest.sgmobiledatausage

import android.app.Application
import com.sg.mytest.sgmobiledatausage.framework.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class SGMobileApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        startKoin {
            // for logging purpose
            androidLogger()
            androidContext(this@SGMobileApplication)
            modules(
                listOf(
                    networkModule,
                    databaseModule,
                    dataModule,
                    domainModule,
                    presentationModule
                )
            )
        }

    }
}