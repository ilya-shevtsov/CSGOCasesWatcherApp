package com.example.csgocaseswatcherapp.presentation.view.fragments.caseanalytics

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
import com.example.csgocaseswatcherapp.R
import com.example.csgocaseswatcherapp.core.CaseWatcherApplication
import com.example.csgocaseswatcherapp.core.disposeOnDestroy
import com.example.csgocaseswatcherapp.databinding.FragmentCaseAnalyticsBinding
import javax.inject.Inject

class CaseAnalyticsFragment : Fragment(R.layout.fragment_case_analytics) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var binding: FragmentCaseAnalyticsBinding

    private lateinit var viewModel: CaseAnalyticsViewModel

    private val adapter: CaseAnalyticsAdapter = CaseAnalyticsAdapter(onItemClicked = { case ->
        val action = CaseAnalyticsFragmentDirections.actionCaseAnalyticsFragmentToCaseAnalyticsDetailsFragment(case)
        findNavController().navigate(action)
    })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCaseAnalyticsBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(CaseAnalyticsViewModel::class.java)

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
            caseAnalyticsRecyclerView.layoutManager = LinearLayoutManager(activity)
            caseAnalyticsRecyclerView.adapter = adapter

            viewModel.viewStateLiveData.observe(viewLifecycleOwner) { state ->
                caseAnalyticsRecyclerView.isVisible = state is CaseAnalyticsViewState.Success
                errorView.root.isVisible = state is CaseAnalyticsViewState.Error

                when (state) {
                    is CaseAnalyticsViewState.Success -> {
                        adapter.addData(state.caseAnalyticsItemList, true)
                    }
                    else -> Unit
                }
            }
        }
        viewModel.getCaseAnalyticsList().disposeOnDestroy(viewLifecycleOwner)
    }

}