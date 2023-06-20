package com.example.pizzashopapplication.presentation.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pizzashopapplication.domain.GetDishesUseCase
import com.example.pizzashopapplication.domain.Repository

class MainViewModelFactory(
    private val useCase: GetDishesUseCase,
    private val repository: Repository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(useCase, repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}