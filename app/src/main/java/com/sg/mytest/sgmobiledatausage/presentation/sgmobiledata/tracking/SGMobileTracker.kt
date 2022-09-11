package com.sg.mytest.sgmobiledatausage.presentation.sgmobiledata.tracking

import timber.log.Timber

class SGMobileTracker {
    fun trackCurrentlyViewingYear(year: String) {
        Timber.d("Screen 2 : You are viewing each year data usage $year year")
    }
}