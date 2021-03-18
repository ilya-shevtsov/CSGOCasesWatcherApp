package com.example.csgocaseswatcherapp.model

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ServerApi {

    @GET("priceoverview/")
    fun getCase(
        @Query("appid") appId: Long,

        @Query("currency") currency: Int,

        @Query(value = "market_hash_name", encoded = true) caseName: String

    ): Single<CaseDto>
}

