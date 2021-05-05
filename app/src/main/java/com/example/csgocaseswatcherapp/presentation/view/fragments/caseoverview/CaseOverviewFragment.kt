package com.example.csgocaseswatcherapp.presentation.view.fragments.caseoverview

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.csgocaseswatcherapp.*
import com.example.csgocaseswatcherapp.core.CaseWatcherApplication
import com.example.csgocaseswatcherapp.core.disposeOnDestroy
import com.example.csgocaseswatcherapp.databinding.FragmentCaseOverviewBinding
import javax.inject.Inject

class CaseOverviewFragment : Fragment(R.layout.fragment_case_overview) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var binding: FragmentCaseOverviewBinding

    private lateinit var viewModel: CaseOverviewViewModel

    private val adapter: CaseOverviewAdapter = CaseOverviewAdapter(onItemClicked = { case ->
        val action =
            CaseOverviewFragmentDirections.actionCaseOverviewFragmentToCaseDetailsFragment(case)
        findNavController().navigate(action)
    })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCaseOverviewBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(CaseOverviewViewModel::class.java)

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (context.applicationContext as CaseWatcherApplication)
            .getAppComponent()
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding) {
            caseRecyclerView.layoutManager = LinearLayoutManager(activity)
            caseRecyclerView.adapter = adapter

            viewModel.viewStateLiveData.observe(viewLifecycleOwner) { state ->

                caseRecyclerView.isVisible = state is CaseOverviewViewState.Success
                errorView.root.isVisible = state is CaseOverviewViewState.Error

                when (state) {
                    is CaseOverviewViewState.Success -> {
                        adapter.addData(state.caseOverviewItemList, true)
                    }
                    else -> Unit
                }
            }
        }
        viewModel.getCaseList().disposeOnDestroy(viewLifecycleOwner)
    }
}
