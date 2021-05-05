package com.example.csgocaseswatcherapp.data.model.caseoverview

import java.io.Serializable
import com.google.gson.annotations.SerializedName

data class CaseDto(

    @SerializedName("success")
    val success: Boolean,

    @SerializedName("name")
    val name: String,

    @SerializedName("releaseDate")
    val releaseDate: String,

    @SerializedName("dropStatus")
    val dropStatus: String,

    @SerializedName("lowestPrice")
    val lowestPrice: Double,

    @SerializedName("volume")
    val volume: Int,

    @SerializedName("medianPrice")
    val medianPrice: Double,

    @SerializedName("imageUrl")
    val imageUrl: String,

    @SerializedName("description")
    val description: String
) : Serializable