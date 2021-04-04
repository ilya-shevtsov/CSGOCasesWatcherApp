package com.example.csgocaseswatcherapp.presentation.model

import com.example.csgocaseswatcherapp.domain.model.CasePreview

object CasePreviewItemMapper {

    fun map(casePreview: CasePreview): CasePreviewItem {
        return CasePreviewItem(
            name = casePreview.name,
            lowestPrice = casePreview.lowestPrice,
            volume = casePreview.volume,
            medianPrice = casePreview.medianPrice,
            imageUrl = casePreview.imageUrl,
            releaseDate = casePreview.releaseDate,
            dropStatus = casePreview.dropStatus,
            description = casePreview.description
        )
    }
}