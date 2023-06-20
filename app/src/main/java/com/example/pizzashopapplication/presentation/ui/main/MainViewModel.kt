package com.example.pizzashopapplication.presentation.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pizzashopapplication.data.model.Dishe
import com.example.pizzashopapplication.domain.DomainDish
import com.example.pizzashopapplication.domain.GetDishesUseCase
import com.example.pizzashopapplication.domain.Repository
import kotlinx.coroutines.launch

class MainViewModel (
    private val useCase: GetDishesUseCase,
    private val repository: Repository
    ) : ViewModel() {

    private var _dishesList = MutableLiveData<List<Dishe>>()
    val dishesList: LiveData<List<Dishe>> get() = _dishesList

    init {
        viewModelScope.launch {
            _dishesList.value = useCase.invoke(repository).value
        }
    }
}