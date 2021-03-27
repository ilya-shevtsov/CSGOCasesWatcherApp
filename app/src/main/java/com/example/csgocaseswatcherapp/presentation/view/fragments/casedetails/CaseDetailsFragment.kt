package com.example.csgocaseswatcherapp.presentation.view.fragments.casedetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.csgocaseswatcherapp.R
import com.example.csgocaseswatcherapp.databinding.FragmentCaseDetailsBinding

class CaseDetailsFragment : Fragment(R.layout.fragment_case_details) {

    private val args by navArgs<CaseDetailsFragmentArgs>()

    private lateinit var binding: FragmentCaseDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCaseDetailsBinding.inflate(inflater, container, false)

        with(binding) {
            caseName.text = args.currentCase.name
            lowestPrice.text = args.currentCase.lowestPrice.toString()
            medianPrice.text = args.currentCase.medianPrice.toString()
            volume.text = args.currentCase.volume.toString()
            caseImage.setImageURI(args.currentCase.imageUrl)
        }


        return binding.root
    }

}