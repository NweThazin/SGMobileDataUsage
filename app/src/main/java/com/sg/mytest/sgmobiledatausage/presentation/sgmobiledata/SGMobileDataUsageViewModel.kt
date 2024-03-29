package com.sg.mytest.sgmobiledatausage.presentation.sgmobiledata

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sg.mytest.sgmobiledatausage.domain.entities.Record
import com.sg.mytest.sgmobiledatausage.domain.entities.MobileDataInfoByYear
import com.sg.mytest.sgmobiledatausage.domain.interactors.GetSGMobileDataUsageUseCase
import com.sg.mytest.sgmobiledatausage.domain.interactors.RetrieveCachedSGMobileDataUsageUseCase
import com.sg.mytest.sgmobiledatausage.framework.network.model.ApiStatus
import com.sg.mytest.sgmobiledatausage.util.DateTimeUtil
import com.sg.mytest.sgmobiledatausage.util.isNetworkAvailable
import kotlinx.coroutines.launch
import timber.log.Timber

class SGMobileDataUsageViewModel(
    val application: Application,
    private val useCase: GetSGMobileDataUsageUseCase,
    private val localUseCase: RetrieveCachedSGMobileDataUsageUseCase
) : ViewModel() {

    private val _apiStatus = MutableLiveData<ApiStatus>()
    val apiStatus: LiveData<ApiStatus> = _apiStatus

    private val _mobileDataInfoByYear = MutableLiveData<List<MobileDataInfoByYear>>()
    val mobileDataInfoByYear: LiveData<List<MobileDataInfoByYear>> = _mobileDataInfoByYear

    private val _selectedIndex = MutableLiveData<Int>()
    val selectedIndex: LiveData<Int> = _selectedIndex

    fun loadSGMobileDataUsage() {
        // if network available, fetch data from network & cache in local storage
        val isNetworkAvailable = application.applicationContext.isNetworkAvailable()
        if (isNetworkAvailable) {
            fetchDataFromNetwork()
        } else {
            // if network is not available, get data from local and show
            fetchDataFromLocal()
        }
    }

    fun fetchDataFromNetwork() {
        _apiStatus.postValue(ApiStatus.LOADING)
        viewModelScope.launch {
            val result = useCase.invoke()
            result.onSuccess { response ->
                val totalVolumeByYear = generateYearsFrom2010(response.result.records)
                _mobileDataInfoByYear.postValue(totalVolumeByYear)
                _apiStatus.postValue(ApiStatus.SUCCESS)
            }.onFailure {
                val message = it.localizedMessage
                Timber.d(message)
                _apiStatus.postValue(ApiStatus.ERROR)
            }
        }
    }

    fun fetchDataFromLocal() {
        viewModelScope.launch {
            val records = localUseCase.invoke()
            _mobileDataInfoByYear.postValue(generateYearsFrom2010(records))
            _apiStatus.postValue(ApiStatus.SUCCESS)
        }
    }

    private fun generateYearsFrom2010(recordList: List<Record>): List<MobileDataInfoByYear> {
        val groupOfDataByYear = recordList.groupBy { it.getMobileDataYear() }
        val currentYear = DateTimeUtil.getCurrentYear()
        val totalVolumeList = arrayListOf<MobileDataInfoByYear>()
        for (year in 2010..currentYear) {
            val totalVolumeByYear = groupOfDataByYear[year.toString()]?.let { records ->
                var dataVolume = 0.0
                records.map { record ->
                    val quarterVolume = record.volumeOfMobileData.toDoubleOrNull() ?: 0.0
                    dataVolume += quarterVolume
                }
                MobileDataInfoByYear(year, dataVolume, records)
            } ?: MobileDataInfoByYear(year, 0.0, emptyList())
            totalVolumeList.add(totalVolumeByYear)
        }
        return totalVolumeList
    }

    // used this function from SGMobileQuarterlyDataUsageFragment
    fun setupArgument(year: Int) {
        mobileDataInfoByYear.value?.let { info ->
            val index = info.indexOfFirst { it.year == year }
            _selectedIndex.postValue(index)
        }
    }
}