package com.example.csgocaseswatcherapp.data.model

data class Case(
    val name: String,
    val lowestPrice: Float,
    val volume: Int,
    val medianPrice: Float
)