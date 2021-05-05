package com.example.csgocaseswatcherapp.domain.repository

import com.example.csgocaseswatcherapp.domain.model.CaseOverview
import io.reactivex.Single

interface CaseRepository {
    fun getCaseOverviewList(): Single<List<CaseOverview>>
}