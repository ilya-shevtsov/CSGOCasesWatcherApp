package com.example.csgocaseswatcherapp.data.model

import java.io.Serializable
import com.google.gson.annotations.SerializedName

data class CaseDto(

    @SerializedName("success")
    val success: Boolean,

    @SerializedName("lowest_price")
    val lowestPrice: String,

    @SerializedName("volume")
    val volume: String,

    @SerializedName("median_price")
    val medianPrice: String

) : Serializable

//{
//    "success":true,
//    "lowest_price":"59,20 pуб.",
//    "volume":"191,830",
//    "median_price":"60,19 pуб."
//}