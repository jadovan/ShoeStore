package com.jadovan.shoestore.models.shoe_detail

import androidx.databinding.BaseObservable

//@BaseObservable
data class Shoe(
    var name: String, var size: Double, var company: String, var description: String,
    val images: List<String> = mutableListOf()
) : BaseObservable()