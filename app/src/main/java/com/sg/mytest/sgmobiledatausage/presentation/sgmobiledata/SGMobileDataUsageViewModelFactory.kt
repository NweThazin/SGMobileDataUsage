package com.sg.mytest.sgmobiledatausage.presentation.sgmobiledata

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sg.mytest.sgmobiledatausage.domain.interactors.GetSGMobileDataUsageUseCase
import java.lang.IllegalArgumentException

class SGMobileDataUsageViewModelFactory(
    private val application: Application,
    private val useCase: GetSGMobileDataUsageUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SGMobileDataUsageViewModel::class.java)) {
            return SGMobileDataUsageViewModel(application, useCase) as T
        }
        throw IllegalArgumentException("Unknown view model type")
    }
}