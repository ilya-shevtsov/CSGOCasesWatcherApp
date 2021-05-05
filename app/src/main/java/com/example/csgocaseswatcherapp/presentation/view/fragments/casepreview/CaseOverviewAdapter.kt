package com.example.csgocaseswatcherapp.presentation.view.fragments.casepreview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.csgocaseswatcherapp.R
import com.example.csgocaseswatcherapp.presentation.model.caseoverviewitem.CaseOverviewItem

class CaseOverviewAdapter constructor(
    private val onItemClicked: (case: CaseOverviewItem) -> Unit
) : RecyclerView.Adapter<CaseOverviewHolder>() {

    private val caseList: MutableList<CaseOverviewItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CaseOverviewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.item_case, parent, false)
        return CaseOverviewHolder(view)
    }

    override fun onBindViewHolder(holder: CaseOverviewHolder, position: Int) {
        val case: CaseOverviewItem = caseList[position]
        holder.bind(case, onItemClicked)
    }

    override fun getItemCount(): Int {
        return caseList.size
    }

    fun addData(data: List<CaseOverviewItem>, refresh: Boolean) {
        if (refresh) {
            caseList.clear()
        }
        caseList.addAll(data)
        notifyDataSetChanged()
    }
}
