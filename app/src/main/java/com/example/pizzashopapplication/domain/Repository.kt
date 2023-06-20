package com.example.pizzashopapplication.domain

import androidx.lifecycle.LiveData
import com.example.pizzashopapplication.data.model.Dishe

interface Repository {
    suspend fun getDishesList() : LiveData<List<Dishe>>
}