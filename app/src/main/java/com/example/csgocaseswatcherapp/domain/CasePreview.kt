package com.example.csgocaseswatcherapp.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


data class CasePreview(
    val name: String,
    val lowestPrice: Float,
    val volume: Int,
    val medianPrice: Float,
    val imageUrl: String
)