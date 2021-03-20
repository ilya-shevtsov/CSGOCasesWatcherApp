package com.example.csgocaseswatcherapp.presentation

import android.util.Log
import com.example.csgocaseswatcherapp.model.ApiTools
import com.example.csgocaseswatcherapp.model.Case
import com.example.csgocaseswatcherapp.model.CaseDto
import com.example.csgocaseswatcherapp.view.CaseView
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit


class CasePresenter(private val view: CaseView) {

    private val caseNameList = listOf(
        "Chroma%20Case",
        "Chroma%202%20Case",
        "Chroma%203%20Case",
        "Clutch%20Case",
        "CS%3AGO%20Weapon%20Case",
//        "CS%3AGO%20Weapon%20Case%202",
//        "CS%3AGO%20Weapon%20Case%203",
//        "CS20%20Case",
//        "Danger%20Zone%20Case",
//        "eSports%202013%20Case",
//        "eSports%202013%20Winter%20Case",
//        "eSports%202014%20Summer%20Case",
//        "Falchion%20Case",
//        "Fracture%20Case",
//        "Gamma%202%20Case",
//        "Gamma%20Case",
//        "Glove%20Case",
//        "Horizon%20Case",
//        "Huntsman%20Weapon%20Case",
//        "Operation%20Bravo%20Case",
//        "Operation%20Breakout%20Weapon%20Case",
//        "Operation%20Broken%20Fang%20Case",
//        "Operation%20Hydra%20Case",
//        "Operation%20Phoenix%20Weapon%20Case",
//        "Operation%20Vanguard%20Weapon%20Case",
//        "Operation%20Wildfire%20Case",
//        "Prisma%20Case",
//        "Prisma%202%20Case",
//        "Revolver%20Case",
//        "Shadow%20Case",
//        "Shattered%20Web%20Case",
//        "Spectrum%202%20Case",
//        "Spectrum%20Case",
//        "Winter%20Offensive%20Weapon%20Case"
    )

    fun getCaseList(): Disposable {
        return Observable.just(caseNameList)
            .toListOfCaseDto()
            .toListOfCase()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = { caseList ->
                    view.showCases(caseList)
                },
                onError = {
                    view.showError()
                    Log.e("M_CasesPreviewFragment.getCaseList", "$it")
                })
    }

    private fun Observable<List<String>>.toListOfCaseDto(): Single<List<Pair<CaseDto, String>>> =
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

    private fun Single<List<Pair<CaseDto, String>>>.toListOfCase(): Single<List<Case>> =
        map { listOfCaseDto ->
            listOfCaseDto.map { (caseDto, caseName) ->
                caseDtoToCase(caseDto, caseName)
            }
        }

    private fun caseDtoToCase(
        caseDto: CaseDto,
        caseName: String
    ): Case {

        val newCaseName = caseName
            .replace("%20", " ")
            .replace("%3A", ":")

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
}
