package com.sg.mytest.sgmobiledatausage.presentation.sgmobiledata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.sg.mytest.sgmobiledatausage.R
import com.sg.mytest.sgmobiledatausage.SGMobileApplication
import com.sg.mytest.sgmobiledatausage.databinding.FragmentSgMobileDataYearListBinding
import com.sg.mytest.sgmobiledatausage.domain.entities.MobileDataInfoByYear
import com.sg.mytest.sgmobiledatausage.presentation.sgmobiledata.adapter.SGMobileDataYearAdapter
import com.sg.mytest.sgmobiledatausage.presentation.sgmobiledata.adapter.SGMobileDataYearListener
import javax.inject.Inject

class SGMobileDataYearListFragment : Fragment() {

    @Inject
    lateinit var factory: SGMobileDataUsageViewModelFactory

    private lateinit var binding: FragmentSgMobileDataYearListBinding
    private lateinit var adapter: SGMobileDataYearAdapter
    private val viewModel: SGMobileDataUsageViewModel by activityViewModels { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SGMobileApplication.getAppComponent().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_sg_mobile_data_year_list,
            container,
            false
        )
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        fetchData()
        setupAdapter()
        observeLiveData()
        return binding.root
    }

    private fun fetchData() {
        viewModel.fetchSGMobileUsage()
    }

    private fun observeLiveData() {
        viewModel.mobileDataInfoByYear.observe(requireActivity(), { items ->
            adapter.setItems(items)
        })
    }

    private fun setupAdapter() {
        val linearLayoutManager = LinearLayoutManager(requireContext())
        adapter = SGMobileDataYearAdapter(object : SGMobileDataYearListener {
            override fun onClickItem(mobileDataInfoByYear: MobileDataInfoByYear) {
                showQuartersByYear(mobileDataInfoByYear)
            }
        })
        binding.rvYears.adapter = adapter
        binding.rvYears.layoutManager = linearLayoutManager

        // add divider item decoration to separate item
        DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL).apply {
            ContextCompat.getDrawable(requireContext(), R.drawable.ic_divider)?.let { drawable ->
                setDrawable(drawable)
            }
            binding.rvYears.addItemDecoration(this)
        }
    }

    private fun showQuartersByYear(mobileDataInfoByYear: MobileDataInfoByYear) {
        val action =
            SGMobileDataYearListFragmentDirections
                .actionSGMobileDataYearListFragmentToSGMobileQuarterlyDataUsageFragment(
                    mobileDataInfoByYear.year
                )
        findNavController().navigate(action)
    }
}