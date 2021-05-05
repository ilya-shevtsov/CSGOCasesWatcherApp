package com.example.csgocaseswatcherapp.domain.repository

import com.example.csgocaseswatcherapp.data.model.caseanalytics.CaseAnalyticsDto
import com.example.csgocaseswatcherapp.domain.model.caseanalytics.CaseAnalytics
import io.reactivex.Single

interface CaseAnalyticsRepository {
    fun getCaseAnalyticsList(): Single<List<CaseAnalytics>>
}