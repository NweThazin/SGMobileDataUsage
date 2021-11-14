package com.sg.mytest.sgmobiledatausage.presentation.sgmobiledata.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sg.mytest.sgmobiledatausage.domain.entities.MobileDataInfoByYear
import com.sg.mytest.sgmobiledatausage.presentation.sgmobiledata.SGMobileEachQuarterDataUsageFragment

class SGMobileQuarterDataPagerAdapter(
    fragment: Fragment,
    private val mobileData: List<MobileDataInfoByYear>
) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return mobileData.size
    }

    override fun createFragment(position: Int): Fragment {
        val item = mobileData[position]
        return SGMobileEachQuarterDataUsageFragment.getInstance(item)
    }
}