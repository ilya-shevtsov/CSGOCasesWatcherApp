package com.example.csgocaseswatcherapp.presentation.view.fragments.addCaseFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
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

        val caseNameArray = resources.getStringArray(R.array.case_name_array)

        val adapter =
            ArrayAdapter(
                requireContext(),
                android.R.layout.simple_list_item_1,
                caseNameArray
            )
        binding.caseNameEditText.threshold = 1
        binding.caseNameEditText.setAdapter(adapter)

        return binding.root
    }
}