package com.example.csgocaseswatcherapp.presentation.view.fragments.caseoverview

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.csgocaseswatcherapp.domain.model.caseoverview.CaseOverview
import com.example.csgocaseswatcherapp.domain.usecase.GetCaseOverviewListUseCase
import com.example.csgocaseswatcherapp.presentation.model.caseoverviewitem.CaseOverviewItemMapper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CaseOverviewViewModel @Inject constructor(
    private val getCaseListUseCase: GetCaseOverviewListUseCase
) : ViewModel() {

    val viewStateLiveData = MutableLiveData<CaseOverviewViewState>()

    fun getCaseList(): Disposable {
        return getCaseListUseCase.getCaseOverviewList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = { caseList ->
                    showCaseList(caseList)
                },
                onError = {
                    showError()
                    Log.e("M_CasesOverviewFragment.getCaseList", "$it")
                }
            )
    }

    private fun showError() {
        val state = CaseOverviewViewState.Error
        viewStateLiveData.postValue(state)
    }

    private fun showCaseList(caseList: List<CaseOverview>) {
        val state = CaseOverviewViewState.Success(
            caseOverviewItemList = caseList.map(CaseOverviewItemMapper::map),
        )
        viewStateLiveData.postValue(state)
    }
}