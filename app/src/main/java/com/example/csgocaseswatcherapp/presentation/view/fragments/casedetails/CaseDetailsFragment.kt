package com.example.csgocaseswatcherapp.presentation.view.fragments.casedetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.csgocaseswatcherapp.R
import com.example.csgocaseswatcherapp.databinding.FragmentCaseDetailsBinding
import com.example.csgocaseswatcherapp.databinding.FragmentPortfolioBinding

class CaseDetailsFragment : Fragment(R.layout.fragment_case_details) {

    private lateinit var binding: FragmentCaseDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCaseDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

}