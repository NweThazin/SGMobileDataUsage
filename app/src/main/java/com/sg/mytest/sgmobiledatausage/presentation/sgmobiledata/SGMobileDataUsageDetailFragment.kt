package com.sg.mytest.sgmobiledatausage.presentation.sgmobiledata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.viewpager2.widget.ViewPager2
import com.sg.mytest.sgmobiledatausage.SGMobileApplication
import com.sg.mytest.sgmobiledatausage.databinding.FragmentSgMobileDataUsageDetailBinding
import com.sg.mytest.sgmobiledatausage.presentation.sgmobiledata.adapter.SGMobileQuarterDataPagerAdapter
import com.sg.mytest.sgmobiledatausage.presentation.sgmobiledata.tracking.SGMobileTracker
import javax.inject.Inject

class SGMobileDataUsageDetailFragment : Fragment() {

    @Inject
    lateinit var factory: SGMobileDataUsageViewModelFactory

    private lateinit var binding: FragmentSgMobileDataUsageDetailBinding
    private val viewModel by activityViewModels<SGMobileDataUsageViewModel> { factory }

    private val tracker = SGMobileTracker()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SGMobileApplication.getAppComponent().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSgMobileDataUsageDetailBinding.inflate(layoutInflater, container, false)
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

        binding.vpMobileData.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                val list = viewModel.mobileDataInfoByYear.value ?: return
                val item = list[position]
                tracker.trackCurrentlyViewingYear(item.year.toString())
            }
        })
    }

    private fun setupArguments() {
        arguments?.let { bundle ->
            val year = SGMobileDataUsageDetailFragmentArgs.fromBundle(bundle).year
            viewModel.setupArgument(year)
        }
    }
}
