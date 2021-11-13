package com.sg.mytest.sgmobiledatausage.presentation.sgmobiledata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sg.mytest.sgmobiledatausage.databinding.FragmentSgMobileDataYearListBinding

class SGMobileDataYearListFragment : Fragment() {

    private lateinit var binding: FragmentSgMobileDataYearListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSgMobileDataYearListBinding.inflate(layoutInflater, container, false)

        return binding.root
    }
}