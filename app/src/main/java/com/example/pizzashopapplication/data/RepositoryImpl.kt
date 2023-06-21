package com.example.pizzashopapplication.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pizzashopapplication.data.model.Dishe
import com.example.pizzashopapplication.domain.DomainDish
import com.example.pizzashopapplication.domain.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val mapper: DishMapper,
    private val apiService:ApiService
) : Repository {

    private val domainListLd = MutableLiveData<List<DomainDish>>()

    override suspend fun getDishesList(): LiveData<List<DomainDish>> {
        try {
            val mappedDish = mapper.mapList(getList())
            domainListLd.value = mappedDish
        } catch (_: Exception) {
        }
        return domainListLd
    }

    private suspend fun getList(): List<Dishe> {
        val result = apiService.getDishes()
        return result.dishes
    }
}