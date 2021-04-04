package com.example.csgocaseswatcherapp.domain.repository

import com.example.csgocaseswatcherapp.domain.model.CasePreview
import io.reactivex.Single

interface CaseRepository {
    fun getCasePreviewList(): Single<List<CasePreview>>
}