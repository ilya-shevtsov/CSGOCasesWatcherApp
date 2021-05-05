package com.example.csgocaseswatcherapp.presentation.view.fragments.caseanalytics

import com.example.csgocaseswatcherapp.presentation.model.caseanalyticsitem.CaseAnalyticsItem

sealed class CaseAnalyticsViewState {

    data class Success(
        val caseAnalyticsItemList: List<CaseAnalyticsItem>
    ) : CaseAnalyticsViewState()

    object Error : CaseAnalyticsViewState()

}
