package com.example.csgocaseswatcherapp.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CasePreviewItem(
    val name: String,
    val lowestPrice: Float,
    val volume: Int,
    val medianPrice: Float,
    val imageUrl: String
) : Parcelable
