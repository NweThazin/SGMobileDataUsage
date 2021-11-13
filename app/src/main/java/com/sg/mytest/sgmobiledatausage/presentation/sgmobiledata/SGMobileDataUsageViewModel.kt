package com.sg.mytest.sgmobiledatausage.presentation.sgmobiledata

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sg.mytest.sgmobiledatausage.domain.interactors.GetSGMobileDataUsageUseCase
import kotlinx.coroutines.launch
import timber.log.Timber

class SGMobileDataUsageViewModel(
    val application: Application,
    private val useCase: GetSGMobileDataUsageUseCase
) : ViewModel() {

    fun fetchSGMobileUsage() {
        viewModelScope.launch {
            val result = useCase.invoke()
            result.onSuccess {
                Timber.d(it.success)
            }.onFailure {
                val message = it.localizedMessage
                Timber.d(message)
            }

        }
    }
}
