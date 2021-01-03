package com.jadovan.shoestore.models.shoe_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.jadovan.shoestore.R
import com.jadovan.shoestore.databinding.ShoeDetailFragmentBinding
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.jadovan.shoestore.MainActivity

class ShoeDetailFragment : Fragment() {

    private val shoeDetailViewModel: ShoeDetailViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: ShoeDetailFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.shoe_detail_fragment,
            container,
            false
        )

        // Set the title in the ActionBar
        (activity as MainActivity).supportActionBar?.title = getString(R.string.shoe_detail_name)

        // Bind the data for the shoe using shoe view model
        binding.shoeViewModel = shoeDetailViewModel
        binding.shoe = Shoe("", 0.0, "", "")

        // Set click listener for the cancel button
        binding.cancelButton.setOnClickListener {
            findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailToShoeList())
        }

        shoeDetailViewModel.message.observe(viewLifecycleOwner, Observer { event ->
            event.getContentIfNotHandled()?.let { message ->
                toast(message)
            }
        })

        return binding.root
    }

    private fun toast(message: Int) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}
