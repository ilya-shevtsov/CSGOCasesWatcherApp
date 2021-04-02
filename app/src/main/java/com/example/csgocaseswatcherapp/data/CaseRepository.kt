package com.example.csgocaseswatcherapp.data

import com.example.csgocaseswatcherapp.data.api.ApiTools
import com.example.csgocaseswatcherapp.domain.CasePreview
import io.reactivex.Single

class CaseRepository {

    fun getCasePreviewList(): Single<List<CasePreview>> {
        val caseDtoListResponse = ApiTools.getApiService()
            .getCaseList()
        return caseDtoListResponse.map { caseDto ->
            caseDto.map { case -> CasePreviewMapper.map(case) }
        }
    }
}

