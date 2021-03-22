package com.example.csgocaseswatcherapp.presentation

import android.util.Log
import com.example.csgocaseswatcherapp.data.CasePreviewMapper
import com.example.csgocaseswatcherapp.data.api.ApiTools
import com.example.csgocaseswatcherapp.domain.CasePreview
import com.example.csgocaseswatcherapp.data.CasePreviewDto
import com.example.csgocaseswatcherapp.domain.GetCaseListUseCase
import com.example.csgocaseswatcherapp.presentation.model.CasePreviewItemMapper
import com.example.csgocaseswatcherapp.presentation.view.CaseView
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit


class CasePresenter(
    private val view: CaseView,
    private val getCaseListUseCase: GetCaseListUseCase
) {

    fun getCaseList(): Disposable {
        return getCaseListUseCase.getCaseList()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = { caseList ->
                    val items = caseList.map(CasePreviewItemMapper::map)
                    view.showCases(items)
                },
                onError = {
                    view.showError()
                    Log.e("M_CasesPreviewFragment.getCaseList", "$it")
                }
            )
    }
}
