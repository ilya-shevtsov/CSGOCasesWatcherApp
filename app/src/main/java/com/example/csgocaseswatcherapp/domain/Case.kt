package com.example.csgocaseswatcherapp.domain

data class Case(
    val name: String,
    val releaseDate: String,
    val dropStatus: String,
    val lowestPrice: Float,
    val volume: Int,
    val medianPrice: Float,
    val imageUrl: String
)