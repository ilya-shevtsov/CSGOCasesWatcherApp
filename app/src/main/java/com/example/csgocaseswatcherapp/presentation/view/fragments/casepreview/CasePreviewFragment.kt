package com.example.csgocaseswatcherapp.presentation.view.fragments.casepreview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.csgocaseswatcherapp.*
import com.example.csgocaseswatcherapp.data.CaseRepository
import com.example.csgocaseswatcherapp.databinding.FragmentCasePreviewBinding
import com.example.csgocaseswatcherapp.domain.GetCaseListUseCase
import com.example.csgocaseswatcherapp.presentation.CasePresenter
import com.example.csgocaseswatcherapp.presentation.model.CasePreviewItem
import com.example.csgocaseswatcherapp.presentation.view.CaseView

class CasePreviewFragment : Fragment(R.layout.fragment_case_preview), CaseView {

    private lateinit var binding: FragmentCasePreviewBinding

    private val adapter: CasePreviewAdapter = CasePreviewAdapter(onItemClicked = { case ->
        val action =
            CasePreviewFragmentDirections.actionCasePreviewFragmentToCaseDetailsFragment(case)
        findNavController().navigate(action)
    })
    private val casePresenter = CasePresenter(this, GetCaseListUseCase(CaseRepository()))


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCasePreviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding) {
            caseRecyclerView.layoutManager = LinearLayoutManager(activity)
            caseRecyclerView.adapter = adapter
        }
        casePresenter.getCaseList().disposeOnDestroy(viewLifecycleOwner)
    }

    override fun showCases(cases: List<CasePreviewItem>) {
        binding.errorView.root.isVisible = false
        adapter.addData(cases, true)
    }

    override fun showError() {
        binding.errorView.root.isVisible = true
    }
}

