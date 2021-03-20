package com.example.csgocaseswatcherapp.view

import android.util.Log
import android.view.View
import com.example.csgocaseswatcherapp.model.Case

class CasePrinter : CaseView {

    override fun showCases(cases: List<Case>) {
        Log.d("sdfsdf", "cases: $cases")
    }
}