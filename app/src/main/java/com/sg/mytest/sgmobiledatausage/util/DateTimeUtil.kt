package com.sg.mytest.sgmobiledatausage.util

import java.util.*

object DateTimeUtil {

    fun getCurrentYear(): Int {
        return Calendar.getInstance().get(Calendar.YEAR)
    }
}