package com.example.pizzashopapplication.presentation.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pizzashopapplication.domain.DomainDish
import com.example.pizzashopapplication.domain.GetDishesUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor (
    private val useCase: GetDishesUseCase
    ) : ViewModel() {

    private var _dishesList = MutableLiveData<List<DomainDish>>()
    val dishesList: LiveData<List<DomainDish>> get() = _dishesList

    init {
        viewModelScope.launch {
            _dishesList.value = useCase.getDishesList().value
        }
    }
}