package com.sg.mytest.sgmobiledatausage

import android.app.Application
import com.sg.mytest.sgmobiledatausage.framework.di.AppComponent
import com.sg.mytest.sgmobiledatausage.framework.di.ApplicationModule
import com.sg.mytest.sgmobiledatausage.framework.di.DaggerAppComponent

class SGMobileApplication : Application() {

    companion object {
        private lateinit var appComponent: AppComponent

        fun getAppComponent(): AppComponent {
            return appComponent
        }
    }

    override fun onCreate() {
        super.onCreate()

        // init dagger
        appComponent = DaggerAppComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }
}