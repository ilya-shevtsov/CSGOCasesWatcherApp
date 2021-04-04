package com.example.csgocaseswatcherapp.presentation.view.fragments.casepreview

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
import com.example.csgocaseswatcherapp.databinding.FragmentCasePreviewBinding
import javax.inject.Inject

class CasePreviewFragment : Fragment(R.layout.fragment_case_preview) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var binding: FragmentCasePreviewBinding

    private lateinit var viewModel: CasePreviewViewModel

    private val adapter: CasePreviewAdapter = CasePreviewAdapter(onItemClicked = { case ->
        val action =
            CasePreviewFragmentDirections.actionCasePreviewFragmentToCaseDetailsFragment(case)
        findNavController().navigate(action)
    })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCasePreviewBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this, viewModelFactory).get(CasePreviewViewModel::class.java)

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
                errorView.root.isVisible = state.isError
                caseRecyclerView.isVisible = !state.isError
                adapter.addData(state.casePreviewItemList, true)
            }
        }
        viewModel.getCaseList().disposeOnDestroy(viewLifecycleOwner)
    }
}
