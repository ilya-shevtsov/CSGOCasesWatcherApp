package com.example.csgocaseswatcherapp.data

import com.example.csgocaseswatcherapp.domain.CasePreview

object CasePreviewMapper {

    fun map(
        caseDto: CasePreviewDto,
        caseName: String
    ): CasePreview {

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

        return CasePreview(
            name = newCaseName,
            lowestPrice = newLowestPrice,
            volume = newVolume,
            medianPrice = newMedianPrice,
            imageUrl = "https://api.steamapis.com/image/item/730/$caseName"
        )
    }
}