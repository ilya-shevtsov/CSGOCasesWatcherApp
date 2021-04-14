package com.example.csgocaseswatcherapp.presentation.view.fragments.casepreview

import com.example.csgocaseswatcherapp.presentation.model.CasePreviewItem

sealed class CasePreviewViewState {

    data class Success(
        val casePreviewItemList: List<CasePreviewItem>,
    ) : CasePreviewViewState()

    object Error: CasePreviewViewState()
}
