package com.example.csgocaseswatcherapp.domain.model

data class Case(
    val name: String,
    val releaseDate: String,
    val dropStatus: String,
    val lowestPrice: Double,
    val volume: Int,
    val medianPrice: Double,
    val imageUrl: String
)