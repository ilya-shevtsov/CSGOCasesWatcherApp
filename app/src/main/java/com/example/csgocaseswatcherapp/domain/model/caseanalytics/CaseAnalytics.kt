package com.example.csgocaseswatcherapp.domain.model.caseanalytics

data class CaseAnalytics(
    val caseName: String,
    val dailyAvgReturnInPercent: Double,
    val dailyAvgReturnInRUB: Double,
    val dailyStandardDeviation: Double,
    val dailySharpRatio: Double,
    val monthlyAvgReturnInPercent: Double,
    val monthlyAvgReturnInRUB: Double,
    val monthlyStandardDeviation: Double,
    val monthlySharpRatio: Double
)
