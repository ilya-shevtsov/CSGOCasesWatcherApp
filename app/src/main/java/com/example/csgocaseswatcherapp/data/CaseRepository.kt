package com.example.csgocaseswatcherapp.data

import com.example.csgocaseswatcherapp.data.api.ApiTools
import com.example.csgocaseswatcherapp.domain.CasePreview
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class CaseRepository {

    fun getCasePreviewList(): List<CasePreview> {
        val caseDtoListResponse = ApiTools.getApiService()
            .getCaseList()
        return caseDtoListResponse.map { case ->
            CasePreviewMapper.map(case)
        }
    }
}

