package com.example.csgocaseswatcherapp.data.model.caseanalytics

import com.example.csgocaseswatcherapp.domain.model.caseanalytics.CaseAnalytics

object CaseAnalyticsMapper {

    fun map(
        caseAnalyticsDto: CaseAnalyticsDto,
    ): CaseAnalytics {
        return CaseAnalytics(
            caseName = caseAnalyticsDto.name,
            dailyAvgReturnInPercent = caseAnalyticsDto.dailyAvgReturnInPercent,
            dailyAvgReturnInRUB = caseAnalyticsDto.dailyAvgReturnInRUB,
            dailyStandardDeviation = caseAnalyticsDto.dailyStandardDeviation,
            dailySharpRatio = caseAnalyticsDto.dailySharpRatio,
            monthlyAvgReturnInPercent = caseAnalyticsDto.monthlyAvgReturnInPercent,
            monthlyAvgReturnInRUB = caseAnalyticsDto.monthlyAvgReturnInRUB,
            monthlyStandardDeviation = caseAnalyticsDto.monthlyStandardDeviation,
            monthlySharpRatio = caseAnalyticsDto.monthlySharpRatio,

            )
    }
}