package com.example.csgocaseswatcherapp.presentation.view.fragments.portfolio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.csgocaseswatcherapp.R
import com.example.csgocaseswatcherapp.databinding.FragmentPortfolioBinding

class PortfolioFragment : Fragment(R.layout.fragment_portfolio) {

    private lateinit var binding:FragmentPortfolioBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPortfolioBinding.inflate(inflater, container, false)

//        binding.navigateToHomeScreenButton.setOnClickListener {
//            findNavController().navigate(R.id.startFragment)
//        }

        return binding.root
    }
}