package com.example.csgocaseswatcherapp.presentation.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.csgocaseswatcherapp.R
import com.example.csgocaseswatcherapp.presentation.model.CasePreviewItem

class CasePreviewAdapter constructor(
    private val onItemClicked: (username: String) -> Unit
) : RecyclerView.Adapter<CasePreviewHolder>() {



    private val caseList: MutableList<CasePreviewItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CasePreviewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.item_case, parent, false)
        return CasePreviewHolder(view)
    }

    override fun onBindViewHolder(holder: CasePreviewHolder, position: Int) {
        val case: CasePreviewItem = caseList[position]
        holder.bind(case, onItemClicked)
    }

    override fun getItemCount(): Int {
        return caseList.size

    }

    fun addData(data: List<CasePreviewItem>, refresh: Boolean) {
        if (refresh) {
            caseList.clear()
        }
        caseList.addAll(data)
        notifyDataSetChanged()
    }
}
