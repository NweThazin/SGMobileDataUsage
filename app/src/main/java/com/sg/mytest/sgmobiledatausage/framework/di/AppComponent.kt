package com.sg.mytest.sgmobiledatausage.framework.di

import com.sg.mytest.sgmobiledatausage.presentation.MainActivity
import com.sg.mytest.sgmobiledatausage.presentation.sgmobiledata.SGMobileDataYearListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        NetworkModule::class,
        DataModule::class,
        DomainModule::class,
        PresentationModule::class
    ]
)
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(fragment: SGMobileDataYearListFragment)
}