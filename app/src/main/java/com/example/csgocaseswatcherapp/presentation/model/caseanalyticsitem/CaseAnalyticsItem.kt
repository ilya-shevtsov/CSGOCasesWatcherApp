package com.example.csgocaseswatcherapp.presentation.model.caseanalyticsitem

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CaseAnalyticsItem(
    val caseName: String,
    val dailyAvgReturnInPercent: Double,
    val dailyAvgReturnInRUB: Double,
    val dailyStandardDeviation: Double,
    val dailySharpRatio: Double,
    val monthlyAvgReturnInPercent: Double,
    val monthlyAvgReturnInRUB: Double,
    val monthlyStandardDeviation: Double,
    val monthlySharpRatio: Double
) : Parcelable
