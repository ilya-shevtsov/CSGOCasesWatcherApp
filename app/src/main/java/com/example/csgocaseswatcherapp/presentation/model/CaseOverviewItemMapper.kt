package com.example.csgocaseswatcherapp.presentation.model

import com.example.csgocaseswatcherapp.domain.model.CaseOverview

object CaseOverviewItemMapper {

    fun map(caseOverview: CaseOverview): CaseOverviewItem {
        return CaseOverviewItem(
            caseName = caseOverview.name,
            lowestPrice = caseOverview.lowestPrice,
            volume = caseOverview.volume,
            medianPrice = caseOverview.medianPrice,
            imageUrl = caseOverview.imageUrl,
            releaseDate = caseOverview.releaseDate,
            dropStatus = caseOverview.dropStatus,
            description = caseOverview.description
        )
    }
}