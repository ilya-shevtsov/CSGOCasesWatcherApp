package com.example.csgocaseswatcherapp.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.csgocaseswatcherapp.R
import com.example.csgocaseswatcherapp.data.model.Case
import com.facebook.drawee.view.SimpleDraweeView
import kotlinx.android.extensions.LayoutContainer

class CasePreviewHolder(
    override val containerView: View
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    private val caseImage: SimpleDraweeView = containerView.findViewById(R.id.listItemCaseImage)
    private val caseName: TextView = containerView.findViewById(R.id.listItemCaseName)
    private val caseLowestPrice: TextView = containerView.findViewById(R.id.listItemLowestPrice)
    private val caseVolume: TextView = containerView.findViewById(R.id.listItemVolume)
    private val caseMedianPrice: TextView = containerView.findViewById(R.id.listItemMedianPrice)

    fun bind(
        case: Case,
        onItemClicked: (caseName: String) -> Unit

    ) {

        caseImage.setImageURI(case.imageUrl)
        caseName.text = case.name
        caseLowestPrice.text = itemView.context.getString(R.string.case_lowest_price, case.lowestPrice.toString())
        caseVolume.text = itemView.context.getString(R.string.case_volume, case.volume.toString())
        caseMedianPrice.text = itemView.context.getString(R.string.case_median_price, case.medianPrice.toString())

    }
}