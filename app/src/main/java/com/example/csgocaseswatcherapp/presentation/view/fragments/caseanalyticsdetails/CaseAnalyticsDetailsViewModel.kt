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
                dailyStandardDeviation = dailyStandardDeviation.toString(),
                dailySharpRatio = dailySharpRatio.toString(),
                monthlyAvgReturnInPercent = monthlyAvgReturnInPercent.toString(),
                monthlyAvgReturnInRUB = monthlyAvgReturnInRUB.toString(),
                monthlyStandardDeviation = monthlyStandardDeviation.toString(),
                monthlySharpRatio = monthlySharpRatio.toString()
            )
            viewStateLiveData.postValue(state)
        }
    }
}