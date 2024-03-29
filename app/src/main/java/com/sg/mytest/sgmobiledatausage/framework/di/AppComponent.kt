package com.sg.mytest.sgmobiledatausage.framework.di

import com.sg.mytest.sgmobiledatausage.presentation.MainActivity
import com.sg.mytest.sgmobiledatausage.presentation.sgmobiledata.SGMobileDataUsageYearListFragment
import com.sg.mytest.sgmobiledatausage.presentation.sgmobiledata.SGMobileDataUsageDetailFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        NetworkModule::class,
        DataModule::class,
        DomainModule::class,
        PresentationModule::class,
        DatabaseModule::class
    ]
)
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(fragmentUsage: SGMobileDataUsageYearListFragment)
    fun inject(detailFragment: SGMobileDataUsageDetailFragment)
}