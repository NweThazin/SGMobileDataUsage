package com.sg.mytest.sgmobiledatausage.presentation.sgmobiledata.adapter

import com.sg.mytest.sgmobiledatausage.domain.entities.TotalVolumeByYear

interface SGMobileDataYearListener {
    fun onClickItem(totalVolumeByYear: TotalVolumeByYear)
}