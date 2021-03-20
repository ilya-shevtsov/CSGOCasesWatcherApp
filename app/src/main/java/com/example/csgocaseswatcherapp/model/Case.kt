package com.example.csgocaseswatcherapp.model

data class Case(
    val name: String,
    val lowestPrice: Float,
    val volume: Int,
    val medianPrice: Float,
    val imageUrl:String
)