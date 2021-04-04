package com.example.csgocaseswatcherapp.data.api

import com.example.csgocaseswatcherapp.data.model.CaseDto
import io.reactivex.Single
import retrofit2.http.GET

interface ServerApi {

//    @GET("priceoverview/")
//    fun getCase(
//        @Query("appid") appId: Long,
//
//        @Query("currency") currency: Int,
//
//        @Query(value = "market_hash_name", encoded = true) caseName: String
//
//    ): Single<CasePreviewDto>

    @GET("getCase")
    fun getCaseList(): Single<List<CaseDto>>
}

