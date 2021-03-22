package com.example.csgocaseswatcherapp.data

import com.example.csgocaseswatcherapp.data.api.ApiTools
import com.example.csgocaseswatcherapp.domain.CasePreview
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class CaseRepository {

    fun getCaseList(caseNameList: List<String>): Single<List<CasePreview>> {
        return Observable.just(caseNameList)
            .toListOfCaseDto()
            .toListOfCase()
            .subscribeOn(Schedulers.io())
    }

    private fun Observable<List<String>>.toListOfCaseDto(): Single<List<Pair<CasePreviewDto, String>>> =
        flatMap { caseNameList -> Observable.fromIterable(caseNameList) }
            .concatMap { caseName ->
                ApiTools.getApiService()
                    .getCase(
                        appId = 730,
                        currency = 5,
                        caseName = caseName
                    ).toObservable().map { caseDto ->
                        caseDto to caseName

                    }
                    .retryWhen {
                        Observable.timer(60, TimeUnit.SECONDS)
                    }
            }
            .toList()

    private fun Single<List<Pair<CasePreviewDto, String>>>.toListOfCase(): Single<List<CasePreview>> =
        map { listOfCaseDto ->
            listOfCaseDto.map { (caseDto, caseName) ->
                CasePreviewMapper.map(caseDto, caseName)
            }
        }
}
