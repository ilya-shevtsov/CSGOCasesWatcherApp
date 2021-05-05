package com.example.csgocaseswatcherapp.presentation.view.fragments.caseanalytics

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.csgocaseswatcherapp.R
import com.example.csgocaseswatcherapp.presentation.model.caseanalyticsitem.CaseAnalyticsItem

class CaseAnalyticsAdapter constructor(
    private val onItemClicked: (case: CaseAnalyticsItem) -> Unit
) : RecyclerView.Adapter<CaseAnalyticsHolder>() {

    private val caseList: MutableList<CaseAnalyticsItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CaseAnalyticsHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.item_case_analytics, parent, false)
        return CaseAnalyticsHolder(view)
    }

    override fun onBindViewHolder(holder: CaseAnalyticsHolder, position: Int) {
        val case: CaseAnalyticsItem = caseList[position]
        holder.bind(case, onItemClicked)
    }

    override fun getItemCount(): Int {
        return caseList.size
    }

    fun addData(data: List<CaseAnalyticsItem>, refresh: Boolean) {
        if (refresh) {
            caseList.clear()
        }
        caseList.addAll(data)
        notifyDataSetChanged()
    }
}
