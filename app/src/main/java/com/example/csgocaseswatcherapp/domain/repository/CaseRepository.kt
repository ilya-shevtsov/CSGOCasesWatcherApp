package com.example.csgocaseswatcherapp.domain.repository

import com.example.csgocaseswatcherapp.domain.model.caseoverview.CaseOverview
import io.reactivex.Single

interface CaseRepository {
    fun getCaseOverviewList(): Single<List<CaseOverview>>
}