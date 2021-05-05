package com.example.csgocaseswatcherapp.presentation.view.fragments.caseoverviewdetails

data class CaseDetailsViewState(
    val caseName: String,
    val lowestPrice: String,
    val medianPrice: String,
    val volume: String,
    val releaseDate: String,
    val dropStatus: String,
    val description: String,
    val caseImage: String
)

