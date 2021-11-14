package com.sg.mytest.sgmobiledatausage.presentation.sgmobiledata.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sg.mytest.sgmobiledatausage.presentation.sgmobiledata.SGMobileEachQuarterDataUsageFragment

class SGMobileQuarterDataPagerAdapter(
    fragment: Fragment,
    private val data: List<String>

) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return data.size
    }

    override fun createFragment(position: Int): Fragment {
        val check = data[position]
        return SGMobileEachQuarterDataUsageFragment.getInstance(position, check)
    }
}