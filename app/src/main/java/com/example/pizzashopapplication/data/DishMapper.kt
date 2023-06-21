package com.example.pizzashopapplication.data

import android.util.Log
import com.example.pizzashopapplication.data.model.Dishe
import com.example.pizzashopapplication.domain.DomainDish
import javax.inject.Inject

class DishMapper @Inject constructor() {

    private fun mapToDomainDish(item: Dishe) =
        DomainDish(
            item.description,
            item.id,
            item.image_url,
            item.name,
            item.price,
            item.tegs,
            item.weight
        )

    fun mapToDish(item: DomainDish) =
        Dishe(
            item.description,
            item.id,
            item.image_url,
            item.name,
            item.price,
            item.tegs,
            item.weight
        )

    fun mapList(dataList: List<Dishe>): List<DomainDish> = dataList.map {
        Log.d("MenuAdapter", "mapper: $it")
        mapToDomainDish(it)
    }
}