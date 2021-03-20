package com.example.csgocaseswatcherapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.csgocaseswatcherapp.*
import com.example.csgocaseswatcherapp.model.Case
import com.example.csgocaseswatcherapp.presentation.CasePresenter

class CasePreviewFragment : Fragment(), CaseView {

    private lateinit var errorView: View
    private lateinit var recycler: RecyclerView
    private val adapter: CasePreviewAdapter = CasePreviewAdapter(onItemClicked = {})
    private val casePresenter = CasePresenter(this)

    companion object {
        fun newInstance(): CasePreviewFragment {
            return CasePreviewFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_case_preview, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recycler = view.findViewById(R.id.fragmentCasePreviewRecycler)
        recycler.layoutManager = LinearLayoutManager(activity)
        recycler.adapter = adapter
        errorView = view.findViewById(R.id.errorView)
        casePresenter.getCaseList().disposeOnDestroy(viewLifecycleOwner)

    }

    override fun showCases(cases: List<Case>) {
        errorView.isVisible = false
        adapter.addData(cases, true)
    }

    override fun showError() {
        errorView.isVisible = true
    }
}

