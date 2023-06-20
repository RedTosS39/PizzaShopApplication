package com.example.pizzashopapplication.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pizzashopapplication.data.model.Dishe
import com.example.pizzashopapplication.domain.Repository

class RepositoryImpl(

) : Repository {
    private val mapper = DishMapper()
    private val apiService = ApiService.create()
    private val domainListLd = MutableLiveData<List<Dishe>>()

    override suspend fun getDishesList(): LiveData<List<Dishe>> {
        try {

            domainListLd.value = getList()
        } catch (_: Exception) {
        }
        return domainListLd
    }

    private suspend fun getList(): List<Dishe> {
        val result = apiService.getDishes()
        return result.dishes
    }
}