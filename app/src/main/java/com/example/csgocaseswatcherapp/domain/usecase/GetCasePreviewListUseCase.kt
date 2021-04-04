package com.example.csgocaseswatcherapp.domain.usecase

import com.example.csgocaseswatcherapp.domain.model.CasePreview
import com.example.csgocaseswatcherapp.domain.repository.CaseRepository
import io.reactivex.Single
import javax.inject.Inject

class GetCasePreviewListUseCase @Inject constructor(
    private val caseRepository: CaseRepository
) {

    fun getCasePreviewList(): Single<List<CasePreview>> {
        return caseRepository.getCasePreviewList()
    }
}