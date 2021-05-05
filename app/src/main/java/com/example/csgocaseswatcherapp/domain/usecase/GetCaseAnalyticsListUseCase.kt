package com.example.csgocaseswatcherapp.domain.usecase

import com.example.csgocaseswatcherapp.domain.model.caseanalytics.CaseAnalytics
import com.example.csgocaseswatcherapp.domain.repository.CaseAnalyticsRepository
import io.reactivex.Single
import javax.inject.Inject

class GetCaseAnalyticsListUseCase @Inject constructor(
    private val caseAnalyticsRepository: CaseAnalyticsRepository
) {

    fun getCaseAnalyticsList(): Single<List<CaseAnalytics>> {
        return caseAnalyticsRepository.getCaseAnalyticsList()
    }
}

