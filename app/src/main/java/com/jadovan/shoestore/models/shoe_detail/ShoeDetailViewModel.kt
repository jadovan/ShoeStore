package com.jadovan.shoestore.models.shoe_detail

import com.jadovan.shoestore.Event
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.jadovan.shoestore.R

class ShoeDetailViewModel : ViewModel() {

    // Construct live data object
    private var _shoeDetails = MutableLiveData<ArrayList<Shoe>>()
    val shoeDetails: LiveData<ArrayList<Shoe>>
        get() = _shoeDetails

    init {
        _shoeDetails.value = ArrayList()
    }

    // Construct object for Toast message
    private val _message = MutableLiveData<Event<Int>>()
    val message: LiveData<Event<Int>>
        get() = _message

    // Function for saving the shoe details
    fun onSave(view: View, shoe: Shoe) =
        if (shoe.name.isNotEmpty() && shoe.company.isNotEmpty() && shoe.size >= 0.0) {
            _shoeDetails.value?.add(shoe)
            _message.value = Event(R.string.shoe_detail_success)
            onNavigateUp(view)
        } else {
            _message.value = Event(R.string.shoe_detail_warning)
        }

    // Function for the navigation of the up button
    private fun onNavigateUp(view: View) {
        view.findNavController().navigateUp()
    }
}