package com.example.csgocaseswatcherapp.data.repository

import com.example.csgocaseswatcherapp.data.model.caseoverview.CaseOverviewMapper
import com.example.csgocaseswatcherapp.data.api.ApiTools
import com.example.csgocaseswatcherapp.domain.model.caseoverview.CaseOverview
import com.example.csgocaseswatcherapp.domain.repository.CaseRepository
import io.reactivex.Single
import javax.inject.Inject

class CaseRepositoryImpl @Inject constructor(

) : CaseRepository {

    override fun getCaseOverviewList(): Single<List<CaseOverview>> {
        val caseDtoListResponse = ApiTools.getApiService()
            .getCaseList()
        return caseDtoListResponse.map { caseDto ->
            caseDto.map { case -> CaseOverviewMapper.map(case) }
        }
    }
}

