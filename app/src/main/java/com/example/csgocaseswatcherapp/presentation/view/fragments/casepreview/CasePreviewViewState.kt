package com.example.csgocaseswatcherapp.presentation.view.fragments.casepreview

import com.example.csgocaseswatcherapp.presentation.model.CasePreviewItem

data class CasePreviewViewState(
    val casePreviewItemList: List<CasePreviewItem>,
    val isError: Boolean
)