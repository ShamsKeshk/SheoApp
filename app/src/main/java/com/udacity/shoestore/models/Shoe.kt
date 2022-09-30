package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(var name: String? = null ,var size: Double? = 0.0, var company: String? = null,
                var description: String? = null,
                val images: List<String> = mutableListOf()) : Parcelable