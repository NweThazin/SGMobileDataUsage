package com.sg.mytest.sgmobiledatausage.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sg.mytest.sgmobiledatausage.R
import com.sg.mytest.sgmobiledatausage.SGMobileApplication
import com.sg.mytest.sgmobiledatausage.data.datasource.SGMobileDataSource
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    // to remove it
    @Inject
    lateinit var dataSource: SGMobileDataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SGMobileApplication.getAppComponent().inject(this)
        setContentView(R.layout.activity_main)
    }
}