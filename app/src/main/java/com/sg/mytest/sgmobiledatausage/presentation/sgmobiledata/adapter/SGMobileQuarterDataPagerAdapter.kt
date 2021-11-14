package com.sg.mytest.sgmobiledatausage.presentation.sgmobiledata.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sg.mytest.sgmobiledatausage.domain.entities.MobileDataInfoByYear
import com.sg.mytest.sgmobiledatausage.presentation.sgmobiledata.SGMobileEachQuarterDataUsageFragment

class SGMobileQuarterDataPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val mobileData: List<MobileDataInfoByYear>
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return mobileData.size
    }

    override fun createFragment(position: Int): Fragment {
        val item = mobileData[position]
        return SGMobileEachQuarterDataUsageFragment.getInstance(item)
    }
}