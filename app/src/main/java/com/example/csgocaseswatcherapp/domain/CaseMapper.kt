package com.example.csgocaseswatcherapp.domain

import com.example.csgocaseswatcherapp.domain.Case
import com.example.csgocaseswatcherapp.domain.CasePreview

object CaseMapper {

    fun map(
        casePreview: CasePreview,
        caseDate: String,
        caseDropStatus: String
    ): Case {

        val newCaseName = casePreview.name

        val newLowestPrice = casePreview.lowestPrice

        val newVolume = casePreview.volume

        val newMedianPrice = casePreview.medianPrice

        val newImageURL = casePreview.imageUrl

        return Case(
            name = newCaseName,
            lowestPrice = newLowestPrice,
            volume = newVolume,
            medianPrice = newMedianPrice,
            imageUrl = newImageURL,
            releaseDate = caseDate,
            dropStatus = caseDropStatus
        )
    }
}