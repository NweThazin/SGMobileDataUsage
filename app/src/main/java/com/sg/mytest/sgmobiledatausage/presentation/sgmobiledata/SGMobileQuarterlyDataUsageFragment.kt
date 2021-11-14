package com.sg.mytest.sgmobiledatausage.presentation.sgmobiledata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.sg.mytest.sgmobiledatausage.SGMobileApplication
import com.sg.mytest.sgmobiledatausage.databinding.FragmentSgMobileQuarterlyDataUsageBinding
import com.sg.mytest.sgmobiledatausage.presentation.sgmobiledata.adapter.SGMobileQuarterDataPagerAdapter
import javax.inject.Inject

class SGMobileQuarterlyDataUsageFragment : Fragment() {

    @Inject
    lateinit var factory: SGMobileDataUsageViewModelFactory

    private lateinit var binding: FragmentSgMobileQuarterlyDataUsageBinding
    private val viewModel by activityViewModels<SGMobileDataUsageViewModel> { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SGMobileApplication.getAppComponent().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            FragmentSgMobileQuarterlyDataUsageBinding.inflate(layoutInflater, container, false)

        setupArguments()
        observeLiveData()
        return binding.root
    }

    private fun observeLiveData() {
        viewModel.selectedIndex.observe(requireActivity(), { currentPage ->
            if (isAdded) {
                val list = viewModel.mobileDataInfoByYear.value ?: emptyList()
                val adapter = SGMobileQuarterDataPagerAdapter(
                    requireActivity().supportFragmentManager,
                    requireActivity().lifecycle,
                    list
                )
                binding.vpMobileData.adapter = adapter
                binding.vpMobileData.setCurrentItem(currentPage ?: 0, false)
            }
        })
    }

    private fun setupArguments() {
        arguments?.let { bundle ->
            val year = SGMobileQuarterlyDataUsageFragmentArgs.fromBundle(bundle).year
            viewModel.setupArgument(year)
        }
    }
}
