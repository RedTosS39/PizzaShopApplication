package com.example.pizzashopapplication.domain

import androidx.lifecycle.LiveData
import com.example.pizzashopapplication.data.model.Dishe

class GetDishesUseCase {
    suspend operator fun invoke(repository: Repository) : LiveData<List<Dishe>>{
        return repository.getDishesList()
    }
}