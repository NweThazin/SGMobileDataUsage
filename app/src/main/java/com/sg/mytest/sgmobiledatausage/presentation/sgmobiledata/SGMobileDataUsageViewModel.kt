package com.sg.mytest.sgmobiledatausage.presentation.sgmobiledata

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sg.mytest.sgmobiledatausage.domain.interactors.GetSGMobileDataUsageUseCase
import com.sg.mytest.sgmobiledatausage.framework.network.model.ApiStatus
import kotlinx.coroutines.launch
import timber.log.Timber

class SGMobileDataUsageViewModel(
    val application: Application,
    private val useCase: GetSGMobileDataUsageUseCase
) : ViewModel() {

    private val _apiStatus = MutableLiveData<ApiStatus>()
    val apiStatus: LiveData<ApiStatus> = _apiStatus

    fun fetchSGMobileUsage() {
        _apiStatus.postValue(ApiStatus.LOADING)
        viewModelScope.launch {
            val result = useCase.invoke()
            result.onSuccess {
                Timber.d(it.success)
                _apiStatus.postValue(ApiStatus.SUCCESS)
            }.onFailure {
                val message = it.localizedMessage
                Timber.d(message)
                _apiStatus.postValue(ApiStatus.ERROR)
            }

        }
    }
}
