package com.example.csgocaseswatcherapp.data.repository

import com.example.csgocaseswatcherapp.data.model.caseoverview.CaseOverviewMapper
import com.example.csgocaseswatcherapp.data.api.ApiTools
import com.example.csgocaseswatcherapp.data.model.caseanalytics.CaseAnalyticsMapper
import com.example.csgocaseswatcherapp.domain.model.caseanalytics.CaseAnalytics
import com.example.csgocaseswatcherapp.domain.model.caseoverview.CaseOverview
import com.example.csgocaseswatcherapp.domain.repository.CaseAnalyticsRepository
import io.reactivex.Single
import javax.inject.Inject

class CaseAnalyticsRepositoryImpl @Inject constructor(

) : CaseAnalyticsRepository {

    override fun getCaseAnalyticsList(): Single<List<CaseAnalytics>> {
        val caseAnalyticsDtoListResponse = ApiTools.getApiService()
            .getCaseAnalyticsList()
        return caseAnalyticsDtoListResponse.map { caseAnalyticsDtoList ->
            caseAnalyticsDtoList.map { caseAnalyticsDto -> CaseAnalyticsMapper.map(caseAnalyticsDto) }
        }
    }
}

