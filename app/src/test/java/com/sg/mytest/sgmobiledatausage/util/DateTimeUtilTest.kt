package com.sg.mytest.sgmobiledatausage.util

import org.junit.Assert
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.*

class DateTimeUtilTest {

    @Test
    fun test_getCurrentYear() {
        val formatter = SimpleDateFormat("yyyy", Locale.getDefault())
        val todayDate = Calendar.getInstance().time
        val actualDate = formatter.format(todayDate).toIntOrNull() ?: 0
        Assert.assertEquals(DateTimeUtil.getCurrentYear(), actualDate)
    }
}