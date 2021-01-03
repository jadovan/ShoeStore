package com.jadovan.shoestore.models.instruction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.jadovan.shoestore.MainActivity
import com.jadovan.shoestore.R
import com.jadovan.shoestore.databinding.InstructionFragmentBinding

class InstructionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: InstructionFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.instruction_fragment, container, false
        )

        // Set the title in the ActionBar
        (activity as MainActivity).supportActionBar?.title = getString(R.string.instruction_name)

        // Set click listener for the next button
        binding.nextButton.setOnClickListener {
            findNavController().navigate(InstructionFragmentDirections.actionInstructionToShoeList())
        }
        return binding.root
    }

}