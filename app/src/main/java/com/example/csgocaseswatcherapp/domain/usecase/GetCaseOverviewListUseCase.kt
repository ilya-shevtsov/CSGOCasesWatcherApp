package com.example.csgocaseswatcherapp.domain.usecase

import com.example.csgocaseswatcherapp.domain.model.caseoverview.CaseOverview
import com.example.csgocaseswatcherapp.domain.repository.CaseRepository
import io.reactivex.Single
import javax.inject.Inject

class GetCaseOverviewListUseCase @Inject constructor(
    private val caseRepository: CaseRepository
) {

    fun getCaseOverviewList(): Single<List<CaseOverview>> {
        return caseRepository.getCaseOverviewList()
    }
}