package com.sg.mytest.sgmobiledatausage.presentation.sgmobiledata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sg.mytest.sgmobiledatausage.databinding.FragmentSgMobileDataYearListBinding

class SGMobileDataYearListFragment : Fragment() {

    private lateinit var binding: FragmentSgMobileDataYearListBinding
    private lateinit var adapter: SGMobileDataYearAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSgMobileDataYearListBinding.inflate(layoutInflater, container, false)
        setupAdapter()
        return binding.root
    }

    private fun setupAdapter() {
        val linearLayoutManager = LinearLayoutManager(requireContext())
        adapter = SGMobileDataYearAdapter()
        binding.rvYears.adapter = adapter
        binding.rvYears.layoutManager = linearLayoutManager


        // todo: to change to actual year data
        adapter.setItems(listOf("1", "1", "2"))
    }
}