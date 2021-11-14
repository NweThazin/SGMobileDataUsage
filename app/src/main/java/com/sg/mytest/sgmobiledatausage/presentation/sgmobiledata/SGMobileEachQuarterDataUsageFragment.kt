package com.sg.mytest.sgmobiledatausage.presentation.sgmobiledata

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sg.mytest.sgmobiledatausage.R
import com.sg.mytest.sgmobiledatausage.databinding.FragmentSgMobileEachQuarterDataUsageBinding
import com.sg.mytest.sgmobiledatausage.domain.entities.MobileDataInfoByYear

class SGMobileEachQuarterDataUsageFragment : Fragment() {

    private lateinit var binding: FragmentSgMobileEachQuarterDataUsageBinding

    companion object {
        private const val ARGUMENT_QUARTERLY_DATA = "ARGUMENT_QUARTERLY_DATA"

        fun getInstance(quarterlyData: MobileDataInfoByYear): Fragment {
            val fragment = SGMobileEachQuarterDataUsageFragment()
            val bundle = Bundle()
            bundle.putParcelable(ARGUMENT_QUARTERLY_DATA, quarterlyData)
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
        requireArguments().getParcelable<MobileDataInfoByYear>(ARGUMENT_QUARTERLY_DATA)?.let {
            showMobileUsageByYear(it)
        }
    }

    private fun showMobileUsageByYear(info: MobileDataInfoByYear) {
        binding.apply {
            tvYear.text = resources.getString(R.string.label_year_with_args, info.year)

            if (info.quarterlyRecord.isNotEmpty()) {
                val stringBuilder = SpannableStringBuilder()
                info.quarterlyRecord.map { record ->
                    stringBuilder.append(
                        resources.getString(
                            R.string.label_quarter_with_args,
                            record.quarter
                        )
                    )
                    stringBuilder.append("\n")
                    stringBuilder.append(
                        resources.getString(
                            R.string.label_quarter_volume_od_data_with_args,
                            record.volumeOfMobileData
                        )
                    )
                    stringBuilder.append("\n\n")
                }
                tvQuarterlyDataContent.text = stringBuilder
            } else {
                tvQuarterlyDataContent.text =
                    resources.getString(R.string.error_no_quarter_data_available)
            }
        }
    }
}