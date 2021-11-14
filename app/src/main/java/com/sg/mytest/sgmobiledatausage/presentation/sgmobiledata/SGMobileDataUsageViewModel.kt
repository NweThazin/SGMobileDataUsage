package com.sg.mytest.sgmobiledatausage.presentation.sgmobiledata

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sg.mytest.sgmobiledatausage.domain.entities.Record
import com.sg.mytest.sgmobiledatausage.domain.entities.TotalVolumeByYear
import com.sg.mytest.sgmobiledatausage.domain.interactors.GetSGMobileDataUsageUseCase
import com.sg.mytest.sgmobiledatausage.framework.network.model.ApiStatus
import com.sg.mytest.sgmobiledatausage.util.DateTimeUtil
import kotlinx.coroutines.launch
import timber.log.Timber

class SGMobileDataUsageViewModel(
    val application: Application,
    private val useCase: GetSGMobileDataUsageUseCase
) : ViewModel() {

    private val _apiStatus = MutableLiveData<ApiStatus>()
    val apiStatus: LiveData<ApiStatus> = _apiStatus

    private val _groupOfDataByYear = MutableLiveData<Map<String, List<Record>>>()
    private val groupOfDataByYear: LiveData<Map<String, List<Record>>> = _groupOfDataByYear

    private val _totalVolumeByYear = MutableLiveData<List<TotalVolumeByYear>>()
    val totalVolumeByYear: LiveData<List<TotalVolumeByYear>> = _totalVolumeByYear

    fun fetchSGMobileUsage() {
        _apiStatus.postValue(ApiStatus.LOADING)
        viewModelScope.launch {
            val result = useCase.invoke()
            result.onSuccess { response ->
                val groupOfDataByYear = response.result.records.groupBy { it.getMobileDataYear() }
                val totalVolumeByYear = generateYearsFrom2010(groupOfDataByYear)
                _groupOfDataByYear.postValue(groupOfDataByYear)
                _totalVolumeByYear.postValue(totalVolumeByYear)
                _apiStatus.postValue(ApiStatus.SUCCESS)
            }.onFailure {
                val message = it.localizedMessage
                Timber.d(message)
                _apiStatus.postValue(ApiStatus.ERROR)
            }

        }
    }

    private fun generateYearsFrom2010(groupOfDataByYear: Map<String, List<Record>>): List<TotalVolumeByYear> {
        val currentYear = DateTimeUtil.getCurrentYear()
        val totalVolumeList = arrayListOf<TotalVolumeByYear>()
        for (year in 2010..currentYear) {
            val totalVolumeByYear = groupOfDataByYear[year.toString()]?.let { records ->
                var dataVolume = 0.0
                records.map { record ->
                    val quarterVolume = record.volumeOfMobileData.toDoubleOrNull() ?: 0.0
                    dataVolume += quarterVolume
                }
                TotalVolumeByYear(year, dataVolume)
            } ?: TotalVolumeByYear(year, 0.0)
            totalVolumeList.add(totalVolumeByYear)
        }
        return totalVolumeList
    }

    // used this function from SGMobileQuarterlyDataUsageFragment
    fun setupArgument(volumeByYear: TotalVolumeByYear) {
        groupOfDataByYear.value?.get(volumeByYear.year.toString())?.let { listOfRecords ->
            // todo: to fix it
            println(volumeByYear)
            println(listOfRecords)
            println("do nothing and will start working on it")
        }
    }

}
