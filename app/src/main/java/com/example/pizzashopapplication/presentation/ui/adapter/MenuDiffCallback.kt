package com.example.pizzashopapplication.presentation.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.pizzashopapplication.data.model.Dishe
import com.example.pizzashopapplication.domain.DomainDish

object MenuDiffCallback : DiffUtil.ItemCallback<Dishe>() {
    override fun areItemsTheSame(oldItem: Dishe, newItem: Dishe): Boolean {
       return oldItem.name  == newItem.name
    }

    override fun areContentsTheSame(oldItem: Dishe, newItem: Dishe): Boolean {
        return oldItem == newItem
    }
}