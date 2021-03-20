package com.example.csgocaseswatcherapp.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.csgocaseswatcherapp.R
import com.example.csgocaseswatcherapp.databinding.FragmentCasePreviewBinding
import com.example.csgocaseswatcherapp.databinding.ItemCaseBinding
import com.example.csgocaseswatcherapp.model.Case
import com.facebook.drawee.view.SimpleDraweeView
import kotlinx.android.extensions.LayoutContainer

class CasePreviewHolder(
    override val containerView: View
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    private val binding: ItemCaseBinding = ItemCaseBinding.bind(containerView)

    fun bind(
        case: Case,
        onItemClicked: (caseName: String) -> Unit

    ) {

        with(binding) {
            caseImage.setImageURI(case.imageUrl)
            caseName.text = case.name
            lowestPrice.text =
                itemView.context.getString(R.string.case_lowest_price, case.lowestPrice.toString())
            volume.text = itemView.context.getString(R.string.case_volume, case.volume.toString())
            medianPrice.text =
                itemView.context.getString(R.string.case_median_price, case.medianPrice.toString())
        }
    }
}
