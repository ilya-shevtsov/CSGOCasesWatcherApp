package com.example.csgocaseswatcherapp.presentation.view.fragments.AddCaseFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.csgocaseswatcherapp.R
import com.example.csgocaseswatcherapp.databinding.FragmentAddCaseBinding

class AddCaseFragment : Fragment(R.layout.fragment_add_case) {

    private lateinit var binding: FragmentAddCaseBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentAddCaseBinding.inflate(inflater, container, false)


        return binding.root
    }
}