package com.example.csgocaseswatcherapp.data

import com.example.csgocaseswatcherapp.domain.CasePreview

object CasePreviewMapper {

    fun map(
        caseDto: CaseDto,
    ): CasePreview {

        val newCaseName = caseDto.name

        val newLowestPrice = caseDto.lowestPrice

        val newVolume = caseDto.volume

        val newMedianPrice = caseDto.medianPrice

        val newImageUrl = caseDto.imageUrl


        return CasePreview(
            name = newCaseName,
            lowestPrice = newLowestPrice,
            volume = newVolume,
            medianPrice = newMedianPrice,
            imageUrl = newImageUrl
        )
    }
}