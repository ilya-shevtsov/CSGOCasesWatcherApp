package com.example.csgocaseswatcherapp.presentation.model.caseoverviewitem

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CaseOverviewItem(
    val caseName: String,
    val lowestPrice: Double,
    val volume: Int,
    val medianPrice: Double,
    val imageUrl: String,
    val releaseDate: String,
    val dropStatus: String,
    val description: String
) : Parcelable
