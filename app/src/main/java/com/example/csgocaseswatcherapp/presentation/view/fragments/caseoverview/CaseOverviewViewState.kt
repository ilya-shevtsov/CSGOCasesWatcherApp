package com.example.csgocaseswatcherapp.presentation.view.fragments.caseoverview

import com.example.csgocaseswatcherapp.presentation.model.caseoverviewitem.CaseOverviewItem

sealed class CaseOverviewViewState {

    data class Success(
        val caseOverviewItemList: List<CaseOverviewItem>,
    ) : CaseOverviewViewState()

    object Error: CaseOverviewViewState()
}
