package com.example.csgocaseswatcherapp.presentation.view

import com.example.csgocaseswatcherapp.presentation.model.CasePreviewItem

interface CaseView {

    fun showCases(cases: List<CasePreviewItem>)

    fun showError()
}
