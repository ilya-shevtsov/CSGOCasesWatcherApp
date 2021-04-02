package com.example.csgocaseswatcherapp.data

import com.example.csgocaseswatcherapp.data.api.ApiTools
import com.example.csgocaseswatcherapp.domain.CasePreview

class CaseRepository {

    fun getCasePreviewList(): List<CasePreview> {
        val caseDtoListResponse = ApiTools.getApiService()
            .getCaseList()
        return caseDtoListResponse.map { case ->
            CasePreviewMapper.map(case)
        }
    }
}
