package com.jadovan.shoestore.models.shoe_list

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.ActionBar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.jadovan.shoestore.MainActivity
import com.jadovan.shoestore.R
import com.jadovan.shoestore.databinding.ShoeListFragmentBinding
import com.jadovan.shoestore.databinding.ShoeListItemBinding
import com.jadovan.shoestore.models.shoe_detail.ShoeDetailViewModel

class ShoeListFragment : Fragment() {

    private val shoeDetailViewModel: ShoeDetailViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: ShoeListFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.shoe_list_fragment,
            container, false
        )

        // Set the title in the ActionBar
        (activity as MainActivity).supportActionBar?.title = getString(R.string.shoe_list_name)

        binding.lifecycleOwner = this

        shoeDetailViewModel.shoeDetails.observe(viewLifecycleOwner, {
            for (shoe in it) {
                DataBindingUtil.inflate<ShoeListItemBinding>(
                    layoutInflater,
                    R.layout.shoe_list_item,
                    binding.shoeListItem,
                    true
                ).apply {
                    this.shoe = shoe

                }
            }
        })

        // Set click listener for the plus floating action button
        binding.addFab.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListToShoeDetail())
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    // Function for the overflow menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)

        // Remove up arrow to prevent user from going back to login screen
        val actionBar: ActionBar? = (activity as MainActivity).supportActionBar
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(false) // disable the button
            actionBar.setDisplayHomeAsUpEnabled(false) // remove the left caret
            actionBar.setDisplayShowHomeEnabled(false) // remove the icon
        }
    }

    // Function for selecting the logout option in the overflow menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.LoginFragment) {
            onLogout()
        }
        return super.onOptionsItemSelected(item)
    }

    // Function for logging out and returning to the login fragment
    private fun onLogout() {
        findNavController().navigate(ShoeListFragmentDirections.actionShoeListToLogin())
    }


}