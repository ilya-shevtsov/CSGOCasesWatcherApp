package com.example.csgocaseswatcherapp.presentation

import android.util.Log
import com.example.csgocaseswatcherapp.domain.GetCasePreviewListUseCase
import com.example.csgocaseswatcherapp.presentation.model.CasePreviewItemMapper
import com.example.csgocaseswatcherapp.presentation.view.CaseView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class CasePresenter(
    private val view: CaseView,
    private val getCaseListUseCase: GetCasePreviewListUseCase
) {

    fun getCaseList(): Disposable {
        return getCaseListUseCase.getCasePreviewList()
            .subscribeOn(Schedulers.io())
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
