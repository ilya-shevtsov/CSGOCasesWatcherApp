package com.example.csgocaseswatcherapp.presentation.view.fragments.caseanalyticsdetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.csgocaseswatcherapp.presentation.model.caseanalyticsitem.CaseAnalyticsItem
import javax.inject.Inject

class CaseAnalyticsDetailsViewModel @Inject constructor(
) : ViewModel() {

    val viewStateLiveData = MutableLiveData<CaseAnalyticsDetailsViewState>()

    fun onItemProvided(currentCase: CaseAnalyticsItem) {
        with(currentCase) {
            val state = CaseAnalyticsDetailsViewState(
                caseName = caseName,
                dailyAvgReturnInPercent = dailyAvgReturnInPercent.toString(),
                dailyAvgReturnInRUB = dailyAvgReturnInRUB.toString(),
                dailyStandardDeviation = String.format("%.2f", dailyStandardDeviation),
                dailySharpRatio = String.format("%.2f", dailySharpRatio),
                monthlyAvgReturnInPercent = monthlyAvgReturnInPercent.toString(),
                monthlyAvgReturnInRUB = monthlyAvgReturnInRUB.toString(),
                monthlyStandardDeviation = String.format("%.2f", monthlyStandardDeviation),
                monthlySharpRatio = String.format("%.2f", monthlySharpRatio)
            )
            viewStateLiveData.postValue(state)
        }
    }
}