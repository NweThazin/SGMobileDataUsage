package com.sg.mytest.sgmobiledatausage.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sg.mytest.sgmobiledatausage.SGMobileApplication
import com.sg.mytest.sgmobiledatausage.databinding.ActivityMainBinding
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.sg.mytest.sgmobiledatausage.R

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        SGMobileApplication.getAppComponent().inject(this)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}