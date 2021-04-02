package com.example.csgocaseswatcherapp.domain

import com.example.csgocaseswatcherapp.data.CaseRepository
import io.reactivex.Single

class GetCaseListUseCase(private val caseRepository: CaseRepository) {

    private val caseNameList = listOf(
        "Chroma%20Case",
        "Chroma%202%20Case",
        "Chroma%203%20Case",
        "Clutch%20Case",
        "CS%3AGO%20Weapon%20Case",
        "CS%3AGO%20Weapon%20Case%202",
        "CS%3AGO%20Weapon%20Case%203",
        "CS20%20Case",
        "Danger%20Zone%20Case",
        "eSports%202013%20Case",
        "eSports%202013%20Winter%20Case",
        "eSports%202014%20Summer%20Case",
        "Falchion%20Case",
        "Fracture%20Case",
        "Gamma%202%20Case",
        "Gamma%20Case",
        "Glove%20Case",
        "Horizon%20Case",
        "Huntsman%20Weapon%20Case",
        "Operation%20Bravo%20Case",
        "Operation%20Breakout%20Weapon%20Case",
        "Operation%20Broken%20Fang%20Case",
        "Operation%20Hydra%20Case",
        "Operation%20Phoenix%20Weapon%20Case",
        "Operation%20Vanguard%20Weapon%20Case",
        "Operation%20Wildfire%20Case",
        "Prisma%20Case",
        "Prisma%202%20Case",
        "Revolver%20Case",
        "Shadow%20Case",
        "Shattered%20Web%20Case",
        "Spectrum%202%20Case",
        "Spectrum%20Case",
        "Winter%20Offensive%20Weapon%20Case"
    )


    private val caseList = listOf<Case>(
        Case("Chroma Case",
            "08.01.2015",
            "Inactive (Rare)",
            64.23,3803,
            62.54,
            "https://api.steamapis.com/image/item/730/Chroma%20Case"),
        Case("Chroma Case",
            "08.01.2015",
            "Inactive (Rare)",
            2645.23,200,
            2658.54,
            "https://api.steamapis.com/image/item/730/Operation%20Bravo%20Case"),
        Case("Chroma Case",
            "08.01.2015",
            "Inactive (Rare)",
            2045.23,259,
            2059.66,
            "https://api.steamapis.com/image/item/730/eSports%202013%20Case"))

    fun getCasePreviewList(): Single<List<CasePreview>> {
        return caseRepository.getCaseList(caseNameList)
    }
}