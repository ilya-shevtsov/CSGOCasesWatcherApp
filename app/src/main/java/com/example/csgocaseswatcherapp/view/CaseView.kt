package com.example.csgocaseswatcherapp.view

import com.example.csgocaseswatcherapp.model.Case

interface CaseView {

    fun showCases(cases: List<Case>)

    fun showError()
}
