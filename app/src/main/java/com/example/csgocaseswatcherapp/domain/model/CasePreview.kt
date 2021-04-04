package com.example.csgocaseswatcherapp.domain.model

data class CasePreview(
    val name: String,
    val lowestPrice: Double,
    val volume: Int,
    val medianPrice: Double,
    val imageUrl: String
)