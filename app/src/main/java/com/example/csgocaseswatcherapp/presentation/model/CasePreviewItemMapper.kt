package com.example.csgocaseswatcherapp.presentation.model

import com.example.csgocaseswatcherapp.domain.model.CasePreview

object CasePreviewItemMapper {

    fun map(case: CasePreview): CasePreviewItem {
        return CasePreviewItem(
            name = case.name,
            lowestPrice = case.lowestPrice,
            volume = case.volume,
            medianPrice = case.medianPrice,
            imageUrl = case.imageUrl,
            releaseDate = case.releaseDate,
            dropStatus = case.dropStatus,
            description = case.description
        )
    }
}