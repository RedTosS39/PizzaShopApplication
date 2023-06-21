package com.example.pizzashopapplication.presentation.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.pizzashopapplication.data.model.Dishe
import com.example.pizzashopapplication.domain.DomainDish

object MenuDiffCallback : DiffUtil.ItemCallback<DomainDish>() {
    override fun areItemsTheSame(oldItem: DomainDish, newItem: DomainDish): Boolean {
       return oldItem.name  == newItem.name
    }

    override fun areContentsTheSame(oldItem: DomainDish, newItem: DomainDish): Boolean {
        return oldItem == newItem
    }
}