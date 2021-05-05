package com.example.csgocaseswatcherapp.data.model.caseanalytics

import java.io.Serializable
import com.google.gson.annotations.SerializedName

data class CaseAnalyticsDto(

    @SerializedName("name")
    val name: String,

    @SerializedName("dailyAvgReturnInPercent")
    val dailyAvgReturnInPercent: Double,

    @SerializedName("dailyAvgReturnInRUB")
    val dailyAvgReturnInRUB: Double,

    @SerializedName("dailyStandardDeviation")
    val dailyStandardDeviation: Double,

    @SerializedName("dailySharpRatio")
    val dailySharpRatio: Double,

    @SerializedName("monthlyAvgReturnInPercent")
    val monthlyAvgReturnInPercent: Double,

    @SerializedName("monthlyAvgReturnInRUB")
    val monthlyAvgReturnInRUB: Double,

    @SerializedName("monthlyStandardDeviation")
    val monthlyStandardDeviation: Double,

    @SerializedName("monthlySharpRatio")
    val monthlySharpRatio: Double
) : Serializable