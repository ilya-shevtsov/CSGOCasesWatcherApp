package com.example.csgocaseswatcherapp.presentation.view.fragments.casedetails

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.csgocaseswatcherapp.R
import com.example.csgocaseswatcherapp.core.CaseWatcherApplication
import com.example.csgocaseswatcherapp.databinding.FragmentCaseDetailsBinding
import javax.inject.Inject

class CaseDetailsFragment : Fragment(R.layout.fragment_case_details) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: CaseDetailsViewModel

    private val args by navArgs<CaseDetailsFragmentArgs>()

    private lateinit var binding: FragmentCaseDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCaseDetailsBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this, viewModelFactory).get(CaseDetailsViewModel::class.java)

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

            viewModel.viewStateLiveData.observe(viewLifecycleOwner) { state ->
                caseName.text = state.caseName
                caseImage.setImageURI(state.caseImage)

                lowestPrice.text = getString(R.string.case_lowest_price, state.lowestPrice)
                medianPrice.text = getString(R.string.case_median_price, state.medianPrice)
                volume.text = getString(R.string.case_volume, state.volume)
                releaseDate.text = getString(R.string.case_release_date, state.releaseDate)
                dropStatus.text = getString(R.string.case_drop_status, state.dropStatus)

                description.text = state.description
            }
        }
        viewModel.onItemProvided(args.currentCase)
    }
}