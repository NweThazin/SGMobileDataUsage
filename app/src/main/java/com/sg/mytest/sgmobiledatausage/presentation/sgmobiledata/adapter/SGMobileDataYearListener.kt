package com.sg.mytest.sgmobiledatausage.presentation.sgmobiledata.adapter

import com.sg.mytest.sgmobiledatausage.domain.entities.MobileDataInfoByYear

interface SGMobileDataYearListener {
    fun onClickItem(mobileDataInfoByYear: MobileDataInfoByYear)
}