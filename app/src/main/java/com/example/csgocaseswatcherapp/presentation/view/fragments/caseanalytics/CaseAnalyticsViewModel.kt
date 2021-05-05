package com.example.csgocaseswatcherapp.presentation.view.fragments.caseanalytics

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class CaseAnalyticsViewModel @Inject constructor(
    private val getCaseAnalyticsListUseCase: GetCaseAnalyticsListUseCase
):ViewModel() {

    val viewStateLiveData = MutableLiveData<CaseAnalyticsViewState>()

    fun getCaseAnalyticsList():Disposable{
        return getCaseAnalyticsListUseCase.getCaseAnalyticsList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = { caseAnalyticsList ->
                    showCaseAnalyticsList(caseAnalyticsList)
                },
                onError = {
                    showError()
                    Log.e("M_CasesAnalyticsFragment.getCaseAnalyticsList", "$it")
                }
            )
    }
    private fun showError() {
        val state = CaseAnalyticsViewState.Error
        viewStateLiveData.postValue(state)
    }

    private fun showCaseAnalyticsList(caseAnalyticsList: List<CaseAnalytics>) {
        val state = CaseAnalyticsViewState.Success(
            caseAnalyticsList = caseAnalyticsList.map(CaseAnalyticsItemMapper::map),
        )
        viewStateLiveData.postValue(state)
    }


}
