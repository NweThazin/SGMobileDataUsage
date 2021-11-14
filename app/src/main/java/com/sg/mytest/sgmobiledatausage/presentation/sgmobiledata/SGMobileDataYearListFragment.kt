package com.sg.mytest.sgmobiledatausage.presentation.sgmobiledata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sg.mytest.sgmobiledatausage.R
import com.sg.mytest.sgmobiledatausage.SGMobileApplication
import com.sg.mytest.sgmobiledatausage.databinding.FragmentSgMobileDataYearListBinding
import javax.inject.Inject

class SGMobileDataYearListFragment : Fragment() {

    @Inject
    lateinit var factory: SGMobileDataUsageViewModelFactory

    private lateinit var binding: FragmentSgMobileDataYearListBinding
    private lateinit var adapter: SGMobileDataYearAdapter
    private lateinit var viewModel: SGMobileDataUsageViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        SGMobileApplication.getAppComponent().inject(this)

        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_sg_mobile_data_year_list,
            container,
            false
        )
        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(this, factory)[SGMobileDataUsageViewModel::class.java]
        binding.viewModel = viewModel

        setupAdapter()
        return binding.root
    }

    private fun setupAdapter() {
        val linearLayoutManager = LinearLayoutManager(requireContext())
        adapter = SGMobileDataYearAdapter()
        binding.rvYears.adapter = adapter
        binding.rvYears.layoutManager = linearLayoutManager

        // todo: temp to remove and
        viewModel.fetchSGMobileUsage()

        // todo: to change to actual year data
        adapter.setItems(listOf("1", "1", "2"))
    }
}