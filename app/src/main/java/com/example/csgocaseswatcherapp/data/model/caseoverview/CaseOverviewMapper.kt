package com.example.csgocaseswatcherapp.data.model.caseoverview

import com.example.csgocaseswatcherapp.domain.model.caseoverview.CaseOverview

object CaseOverviewMapper {

    fun map(
        caseDto: CaseDto,
    ): CaseOverview {
        return CaseOverview(
            name = caseDto.name,
            lowestPrice = caseDto.lowestPrice,
            volume = caseDto.volume,
            medianPrice = caseDto.medianPrice,
            imageUrl = caseDto.imageUrl,
            dropStatus = caseDto.dropStatus,
            releaseDate = caseDto.releaseDate,
            description = caseDto.description
        )
    }
}