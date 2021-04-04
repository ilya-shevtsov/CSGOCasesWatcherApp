package com.example.csgocaseswatcherapp.data.model

import com.example.csgocaseswatcherapp.domain.model.CasePreview

object CasePreviewMapper {

    fun map(
        caseDto: CaseDto,
    ): CasePreview {
        return CasePreview(
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