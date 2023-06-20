package com.example.pizzashopapplication.domain

data class DomainDish(
    val description: String,
    val id: Int,
    val imageUrl: String,
    val name: String,
    val price: Int,
    val tegs: List<String>,
    val weight: Int
)
