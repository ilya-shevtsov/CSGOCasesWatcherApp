package com.example.csgocaseswatcherapp.presentation.model.caseanalyticsitem

import com.example.csgocaseswatcherapp.domain.model.caseanalytics.CaseAnalytics

object CaseAnalyticsItemMapper {

    fun map(caseAnalytics: CaseAnalytics): CaseAnalyticsItem {
        return CaseAnalyticsItem(
            caseName = caseAnalytics.caseName,
            dailyAvgReturnInPercent = caseAnalytics.dailyAvgReturnInPercent,
            dailyAvgReturnInRUB = caseAnalytics.dailyAvgReturnInRUB,
            dailyStandardDeviation = caseAnalytics.dailyStandardDeviation,
            dailySharpRatio = caseAnalytics.dailySharpRatio,
            monthlyAvgReturnInPercent = caseAnalytics.monthlyAvgReturnInPercent,
            monthlyAvgReturnInRUB = caseAnalytics.monthlyAvgReturnInRUB,
            monthlyStandardDeviation = caseAnalytics.monthlyStandardDeviation,
            monthlySharpRatio = caseAnalytics.monthlySharpRatio
        )
    }
}