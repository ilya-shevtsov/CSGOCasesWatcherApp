package com.example.csgocaseswatcherapp.domain

data class CasePreview(
    val name: String,
    val lowestPrice: Float,
    val volume: Int,
    val medianPrice: Float,
    val imageUrl: String
)