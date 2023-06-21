package com.example.pizzashopapplication.domain

import androidx.lifecycle.LiveData
import com.example.pizzashopapplication.data.model.Dishe
import javax.inject.Inject

class GetDishesUseCase @Inject constructor(private val repository: Repository) {
    suspend fun getDishesList(): LiveData<List<DomainDish>> {
        return repository.getDishesList()
    }
}