package com.example.csgocaseswatcherapp.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.csgocaseswatcherapp.R
import com.example.csgocaseswatcherapp.common.disposeOnDestroy
import com.example.csgocaseswatcherapp.data.model.Case
import com.example.csgocaseswatcherapp.data.model.CaseDto
import com.example.csgocaseswatcherapp.utils.ApiTools
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class CasePreviewFragment : Fragment() {

    private lateinit var errorView: View
    private lateinit var recycler: RecyclerView
    private val adapter: CasePreviewAdapter = CasePreviewAdapter { }

    companion object {
        fun newInstance(): CasePreviewFragment {
            return CasePreviewFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_case_preview, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recycler = view.findViewById(R.id.fragmentCasePreviewRecycler)
        recycler.layoutManager = LinearLayoutManager(activity)
        recycler.adapter = adapter
        errorView = view.findViewById(R.id.errorView)
        activity!!.setTitle(R.string.cases_preview)
        getCaseList()

    }


    private val caseNameList = listOf("Clutch%20Case", "Prisma%20Case", "Prisma%202%20Case")


    private fun getCaseList() {
        Observable.just(caseNameList)
            .toListOfCaseDto()
            .toListOfCase()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = { caseList ->
                    Log.d("M_CasesPreviewFragment.getCaseList", "$caseList")
                    errorView.isVisible = false
                    adapter.addData(caseList, true)
                },
                onError = {
                    errorView.isVisible = true
                    Log.e("M_CasesPreviewFragment.getCaseList", "$it")
                })
            .disposeOnDestroy(viewLifecycleOwner)
    }

    fun caseDtoToCase(
        caseDto: CaseDto,
        caseName: String
    ): Case {

        val newCaseName = caseName
            .replace("%20", " ")

        val newLowestPrice = caseDto.lowestPrice
            .replace(" pуб.", "")
            .replace(",", ".")
            .toFloat()

        val newVolume = caseDto.volume
            .replace(",", "")
            .toInt()

        val newMedianPrice = caseDto.medianPrice
            .replace(" pуб.", "")
            .replace(",", ".")
            .toFloat()

        return Case(
            name = newCaseName,
            lowestPrice = newLowestPrice,
            volume = newVolume,
            medianPrice = newMedianPrice,
            imageUrl = "https://api.steamapis.com/image/item/730/$caseName"
        )
    }

    fun Single<List<Pair<CaseDto, String>>>.toListOfCase(): Single<List<Case>> =
        map { listOfCaseDto ->
            listOfCaseDto.map { (caseDto, caseName) ->
                caseDtoToCase(caseDto, caseName)
            }
        }

    fun Observable<List<String>>.toListOfCaseDto(): Single<List<Pair<CaseDto, String>>> =
        flatMap { caseNameList -> Observable.fromIterable(caseNameList) }
            .flatMap { caseName ->
                ApiTools.getApiService()
                    .getCase(
                        appId = 730,
                        currency = 5,
                        caseName = caseName
                    ).toObservable().map { caseDto ->
                        caseDto to caseName
                    }
            }
            .toList()
}