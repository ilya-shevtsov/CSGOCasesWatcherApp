package com.example.csgocaseswatcherapp.data.api

import com.example.csgocaseswatcherapp.data.CaseDto
import com.example.csgocaseswatcherapp.domain.Case
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

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

