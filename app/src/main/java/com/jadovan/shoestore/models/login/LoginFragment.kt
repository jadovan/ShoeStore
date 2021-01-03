package com.jadovan.shoestore.models.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.jadovan.shoestore.MainActivity
import com.jadovan.shoestore.R
import com.jadovan.shoestore.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: LoginFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.login_fragment, container, false
        )

        // Set the title in the ActionBar
        (activity as MainActivity).supportActionBar?.title = getString(R.string.login_name)

        // Set click listener for the login button
        binding.loginBtn.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginToWelcome())
        }

        // Set click listener for the new user button
        binding.newUserBtn.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginToWelcome())
        }
        return binding.root
    }

}