package com.example.csgocaseswatcherapp.data.repository

import com.example.csgocaseswatcherapp.data.model.CasePreviewMapper
import com.example.csgocaseswatcherapp.data.api.ApiTools
import com.example.csgocaseswatcherapp.data.api.ServerApi
import com.example.csgocaseswatcherapp.domain.model.CasePreview
import com.example.csgocaseswatcherapp.domain.repository.CaseRepository
import io.reactivex.Single
import javax.inject.Inject

class CaseRepositoryImpl @Inject constructor(

) : CaseRepository {

    override fun getCasePreviewList(): Single<List<CasePreview>> {
        val caseDtoListResponse = ApiTools.getApiService()
            .getCaseList()
        return caseDtoListResponse.map { caseDto ->
            caseDto.map { case -> CasePreviewMapper.map(case) }
        }
    }
}

