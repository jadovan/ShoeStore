package com.jadovan.shoestore.models.shoe_detail

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController

class ShoeDetailViewModel : ViewModel() {

    // Construct live data object
    private var _shoeDetails = MutableLiveData<ArrayList<Shoe>>()
    val shoeDetails: LiveData<ArrayList<Shoe>>
        get() = _shoeDetails

    init {
        _shoeDetails.value = ArrayList()
    }

    // Function for saving the shoe details
    fun onSave(view: View, shoe: Shoe) =
        if (shoe.name.isNotEmpty() && shoe.company.isNotEmpty() && shoe.size >= 0.0) {
            _shoeDetails.value?.add(shoe)
            onNavigateUp(view)
        }
        else {
            // Attempted to use Toast, but creating warning note in details screen
        }

    // Function for the navigation of the up button
    private fun onNavigateUp(view: View) {
        view.findNavController().navigateUp()
    }
}