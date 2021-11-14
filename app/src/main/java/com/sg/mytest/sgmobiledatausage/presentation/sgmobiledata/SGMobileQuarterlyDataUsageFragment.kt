package com.sg.mytest.sgmobiledatausage.presentation.sgmobiledata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.sg.mytest.sgmobiledatausage.SGMobileApplication
import com.sg.mytest.sgmobiledatausage.databinding.FragmentSgMobileQuarterlyDataUsageBinding
import com.sg.mytest.sgmobiledatausage.presentation.sgmobiledata.adapter.SGMobileQuarterDataPagerAdapter
import javax.inject.Inject

class SGMobileQuarterlyDataUsageFragment : Fragment() {

    @Inject
    lateinit var factory: SGMobileDataUsageViewModelFactory

    private lateinit var binding: FragmentSgMobileQuarterlyDataUsageBinding
    private val viewModel by activityViewModels<SGMobileDataUsageViewModel> { factory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        SGMobileApplication.getAppComponent().inject(this)
        binding =
            FragmentSgMobileQuarterlyDataUsageBinding.inflate(layoutInflater, container, false)

        setupArguments()
        setupPagerAdapter()
        return binding.root
    }

    private fun setupArguments() {
        arguments?.let { bundle ->
            val volumeByYear =
                SGMobileQuarterlyDataUsageFragmentArgs.fromBundle(bundle).totalVolumeByYear
            viewModel.setupArgument(volumeByYear)
        }
    }

    private fun setupPagerAdapter() {
        val adapter = SGMobileQuarterDataPagerAdapter(
            requireParentFragment(),
            listOf("adfasdf0", "asdfasdf", "asdfasdf")
        )
        binding.vpMobileData.adapter = adapter
    }
}
