package com.example.csgocaseswatcherapp.domain.repository

import com.example.csgocaseswatcherapp.data.model.caseanalytics.CaseAnalyticsDto
import io.reactivex.Single

interface CaseAnalyticsRepository {
    fun getCaseAnalyticsList(): Single<List<CaseAnalyticsDto>>
}