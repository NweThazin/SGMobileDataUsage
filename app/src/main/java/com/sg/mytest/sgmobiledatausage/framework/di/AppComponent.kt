package com.sg.mytest.sgmobiledatausage.framework.di

import com.sg.mytest.sgmobiledatausage.presentation.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, NetworkModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
}