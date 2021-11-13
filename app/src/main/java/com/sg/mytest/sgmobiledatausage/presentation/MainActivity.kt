package com.sg.mytest.sgmobiledatausage.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sg.mytest.sgmobiledatausage.R
import com.sg.mytest.sgmobiledatausage.SGMobileApplication

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SGMobileApplication.getAppComponent().inject(this)
        setContentView(R.layout.activity_main)
    }
}