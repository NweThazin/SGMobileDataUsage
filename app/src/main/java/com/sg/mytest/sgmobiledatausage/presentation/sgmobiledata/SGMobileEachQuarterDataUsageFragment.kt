package com.sg.mytest.sgmobiledatausage.presentation.sgmobiledata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sg.mytest.sgmobiledatausage.databinding.FragmentSgMobileEachQuarterDataUsageBinding

class SGMobileEachQuarterDataUsageFragment : Fragment() {

    private lateinit var binding: FragmentSgMobileEachQuarterDataUsageBinding

    companion object {
        private const val ARGUMENT_POSITION = "ARGUMENT_POSITION"
        private const val ARGUMENT_QUARTERLY_DATA = "ARGUMENT_QUARTERLY_DATA"

        fun getInstance(position: Int, quarterlyData: String): Fragment {
            val fragment = SGMobileEachQuarterDataUsageFragment()
            val bundle = Bundle()
            bundle.putInt(ARGUMENT_POSITION, position)
            bundle.putString(ARGUMENT_QUARTERLY_DATA, quarterlyData)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            FragmentSgMobileEachQuarterDataUsageBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val position = requireArguments().getInt(ARGUMENT_POSITION)
        val data = requireArguments().getString(ARGUMENT_QUARTERLY_DATA)



        println(position)


    }
}