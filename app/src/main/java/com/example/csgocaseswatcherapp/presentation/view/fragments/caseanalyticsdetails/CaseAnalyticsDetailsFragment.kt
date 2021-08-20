package com.example.csgocaseswatcherapp.presentation.view.fragments.caseanalyticsdetails

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.csgocaseswatcherapp.R
import com.example.csgocaseswatcherapp.core.CaseWatcherApplication
import com.example.csgocaseswatcherapp.databinding.FragmentCaseAnalyticsDetailsBinding
import javax.inject.Inject

class CaseAnalyticsDetailsFragment : Fragment(R.layout.fragment_case_analytics_details) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: CaseAnalyticsDetailsViewModel

    private val args by navArgs<CaseAnalyticsDetailsFragmentArgs>()

    private lateinit var binding: FragmentCaseAnalyticsDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCaseAnalyticsDetailsBinding.inflate(inflater, container, false)

        viewModel =
            ViewModelProvider(this, viewModelFactory).get(CaseAnalyticsDetailsViewModel::class.java)

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (context.applicationContext as CaseWatcherApplication)
            .getAppComponent()
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding) {

            viewModel.viewStateLiveData.observe(viewLifecycleOwner) { state ->
                caseName.text = state.caseName
                dailyAvgReturnInPercentDetails.text = getString(R.string.daily_avg_return_in_percent, state.dailyAvgReturnInPercent)
                dailyAvgReturnInRubDetails.text =
                    getString(R.string.daily_avg_return_in_rub, state.dailyAvgReturnInRUB)
                dailyStandardDeviationDetails.text =
                    getString(R.string.daily_standard_deviation, state.dailyStandardDeviation)
                dailySharpRatioDetails.text = getString(R.string.daily_sharp_ratio, state.dailySharpRatio)
                monthlyAvgReturnInPercentDetails.text = getString(
                    R.string.monthly_avg_return_in_percent,
                    state.monthlyAvgReturnInPercent
                )
                monthlyAvgReturnInRubDetails.text =
                    getString(R.string.monthly_avg_return_in_rub, state.monthlyAvgReturnInRUB)
                monthlyStandardDeviationDetails.text =
                    getString(R.string.monthly_standard_deviation, state.monthlyStandardDeviation)
                monthlySharpRatioDetails.text =
                    getString(R.string.monthly_sharp_ratio, state.monthlySharpRatio)
            }
        }
        viewModel.onItemProvided(args.currentCase)
    }
}