package com.example.pizzashopapplication.data.model


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DishesList(
    val dishes: List<Dishe>
) : Parcelable