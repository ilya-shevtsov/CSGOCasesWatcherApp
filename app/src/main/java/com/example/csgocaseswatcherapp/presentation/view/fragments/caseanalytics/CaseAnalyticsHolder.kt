package com.example.csgocaseswatcherapp.presentation.view.fragments.caseanalytics

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.csgocaseswatcherapp.R
import com.example.csgocaseswatcherapp.databinding.ItemCaseAnalyticsBinding
import com.example.csgocaseswatcherapp.presentation.model.caseanalyticsitem.CaseAnalyticsItem
import kotlinx.android.extensions.LayoutContainer

class CaseAnalyticsHolder(
    override val containerView: View
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    private val binding: ItemCaseAnalyticsBinding = ItemCaseAnalyticsBinding.bind(containerView)

    fun bind(
        case: CaseAnalyticsItem,
        onItemClicked: (case: CaseAnalyticsItem) -> Unit
    ) {
        with(binding) {
            caseImage.setImageURI("https://i5.walmartimages.com/asr/3d09dd36-7035-4b9f-b965-d4a9a36e5c7b_1.bc4a5060a274c0c2db4970d9075daa90.jpeg?odnWidth=612&odnHeight=612&odnBg=ffffff")
            caseName.text = case.caseName
            monthlyAvgReturnInPercent.text = itemView.context.getString(
                R.string.monthly_avg_return_in_percent,
                case.monthlyAvgReturnInPercent.toString()
            )
            monthlyAvgReturnInRub.text = itemView.context.getString(
                R.string.monthly_avg_return_in_rub,
                case.monthlyAvgReturnInRUB.toString()
            )
            rowLayout.setOnClickListener {
                onItemClicked.invoke(case)
            }
        }
    }
}
