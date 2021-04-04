package com.example.csgocaseswatcherapp.presentation.view.fragments.casedetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.csgocaseswatcherapp.presentation.model.CasePreviewItem
import javax.inject.Inject

class CaseDetailsViewModel @Inject constructor(
) : ViewModel() {

    val viewStateLiveData = MutableLiveData<CaseDetailsViewState>()

    fun onItemProvided(currentCase: CasePreviewItem) {
        with(currentCase) {
            val state = CaseDetailsViewState(
                caseName = caseName,
                lowestPrice = lowestPrice.toString(),
                volume = volume.toString(),
                medianPrice = medianPrice.toString(),
                caseImage = imageUrl,
                releaseDate = releaseDate,
                dropStatus = dropStatus,
                description = description
            )
            viewStateLiveData.postValue(state)
        }
    }
}
