package com.example.csgocaseswatcherapp.presentation.view.fragments.caseanalyticsdetails

data class CaseAnalyticsDetailsViewState(
    val caseName: String,
    val dailyAvgReturnInPercent: String,
    val dailyAvgReturnInRUB: String,
    val dailyStandardDeviation: String,
    val dailySharpRatio: String,
    val monthlyAvgReturnInPercent: String,
    val monthlyAvgReturnInRUB: String,
    val monthlyStandardDeviation: String,
    val monthlySharpRatio:String
)