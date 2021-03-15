package com.example.csgocaseswatcherapp.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.csgocaseswatcherapp.R
import com.example.csgocaseswatcherapp.common.disposeOnDestroy
import com.example.csgocaseswatcherapp.utils.ApiTools
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class CasesPreviewFragment : Fragment() {

    private lateinit var errorView: View

    companion object {
        fun newInstance(): CasesPreviewFragment {
            return CasesPreviewFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.case_preview, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        errorView = view.findViewById(R.id.errorView)
        activity!!.setTitle(R.string.cases)
        getCases()

    }

    private fun getCases() {
        getCaseList()
    }

    private val caseNameList = listOf("Glove%20Case")

    private fun getCaseList() {
        Observable.just(caseNameList)
            .flatMap { caseNameList -> Observable.fromIterable(caseNameList) }
            .flatMap { caseName ->
                ApiTools.getApiService()
                    .getCase(
                        appId = 730,
                        currency = 5,
                        caseName = caseName
                    ).toObservable()
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = { caseList ->
                    Log.d("M_CasesPreviewFragment.getCaseList", "$caseList")
                    errorView.isVisible = false
                },
                onError = {
                    errorView.isVisible = true
                    Log.e("M_CasesPreviewFragment.getCaseList", "$it")
                })
            .disposeOnDestroy(viewLifecycleOwner)
    }
}