package com.example.csgocaseswatcherapp.data.api

import com.example.csgocaseswatcherapp.data.model.CaseDto
import io.reactivex.Single
import retrofit2.http.GET

interface ServerApi {

    @GET("getCase")
    fun getCaseList(): Single<List<CaseDto>>
}

