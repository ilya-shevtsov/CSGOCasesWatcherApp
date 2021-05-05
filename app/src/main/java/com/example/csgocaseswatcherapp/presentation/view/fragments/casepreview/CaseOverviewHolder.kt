package com.example.csgocaseswatcherapp.presentation.view.fragments.casepreview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.csgocaseswatcherapp.R
import com.example.csgocaseswatcherapp.databinding.ItemCaseBinding
import com.example.csgocaseswatcherapp.presentation.model.caseoverviewitem.CaseOverviewItem
import kotlinx.android.extensions.LayoutContainer

class CaseOverviewHolder(
    override val containerView: View
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    private val binding: ItemCaseBinding = ItemCaseBinding.bind(containerView)

    fun bind(
        case: CaseOverviewItem,
        onItemClicked: (case: CaseOverviewItem) -> Unit
    ) {

        with(binding) {
            caseImage.setImageURI(case.imageUrl)
            caseName.text = case.caseName
            lowestPrice.text =
                itemView.context.getString(R.string.case_lowest_price, case.lowestPrice.toString())
            volume.text = itemView.context.getString(R.string.case_volume, case.volume.toString())
            medianPrice.text =
                itemView.context.getString(R.string.case_median_price, case.medianPrice.toString())
            rowLayout.setOnClickListener {
                onItemClicked.invoke(case)
            }
        }
    }
}
