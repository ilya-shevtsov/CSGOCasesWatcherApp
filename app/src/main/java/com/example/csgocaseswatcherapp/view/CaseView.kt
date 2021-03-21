package com.example.csgocaseswatcherapp.view

import com.example.csgocaseswatcherapp.model.CasePreview

interface CaseView {

    fun showCases(cases: List<CasePreview>)

    fun showError()
}
