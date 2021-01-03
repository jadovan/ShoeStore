package com.jadovan.shoestore.models.welcome

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.ActionBar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.jadovan.shoestore.MainActivity
import com.jadovan.shoestore.R
import com.jadovan.shoestore.databinding.WelcomeFragmentBinding

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: WelcomeFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.welcome_fragment, container, false
        )

        // Set the title in the ActionBar
        (activity as MainActivity).supportActionBar?.title = getString(R.string.welcome_name)

        // Remove up arrow to prevent user from going back to login screen
        val actionBar: ActionBar? = (activity as MainActivity).supportActionBar
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(false) // disable the button
            actionBar.setDisplayHomeAsUpEnabled(false) // remove the left caret
            actionBar.setDisplayShowHomeEnabled(false) // remove the icon
        }

        // Set click listener for the welcome button
        binding.welcomeBtn.setOnClickListener {
            findNavController().navigate(WelcomeFragmentDirections.actionWelcomeToInstruction())
        }
        return binding.root
    }

}