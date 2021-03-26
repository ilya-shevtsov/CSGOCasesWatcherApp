package com.example.csgocaseswatcherapp.presentation.view.fragments.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.csgocaseswatcherapp.R
import com.example.csgocaseswatcherapp.databinding.FragmentStartBinding


class StartFragment : Fragment(R.layout.fragment_start) {


    private lateinit var binding: FragmentStartBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentStartBinding.inflate(inflater, container, false)

        binding.casePreviewButton.setOnClickListener{
           findNavController().navigate(R.id.casePreviewFragment)
        }

        binding.portfolioButton.setOnClickListener{
            findNavController().navigate(R.id.portfolioFragment)
        }

        return binding.root
    }

}