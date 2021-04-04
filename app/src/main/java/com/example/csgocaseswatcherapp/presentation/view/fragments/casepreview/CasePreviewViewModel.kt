package com.example.csgocaseswatcherapp.presentation.view.fragments.casepreview

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.csgocaseswatcherapp.domain.model.CasePreview
import com.example.csgocaseswatcherapp.domain.usecase.GetCasePreviewListUseCase
import com.example.csgocaseswatcherapp.presentation.model.CasePreviewItemMapper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CasePreviewViewModel @Inject constructor(
    private val getCaseListUseCase: GetCasePreviewListUseCase
) : ViewModel() {

    val viewStateLiveData = MutableLiveData<CasePreviewViewState>()

    fun getCaseList(): Disposable {
        return getCaseListUseCase.getCasePreviewList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = { caseList ->
                    showCaseList(caseList)
                },
                onError = {
                    showError()
                    Log.e("M_CasesPreviewFragment.getCaseList", "$it")
                }
            )
    }

    private fun showError() {
        val state = CasePreviewViewState(
            casePreviewItemList = emptyList(),
            isError = true
        )
        viewStateLiveData.postValue(state)
    }

    private fun showCaseList(caseList: List<CasePreview>) {
        val items = caseList.map(CasePreviewItemMapper::map)
        val state = CasePreviewViewState(
            casePreviewItemList = items,
            isError = false
        )
        viewStateLiveData.postValue(state)
    }
}