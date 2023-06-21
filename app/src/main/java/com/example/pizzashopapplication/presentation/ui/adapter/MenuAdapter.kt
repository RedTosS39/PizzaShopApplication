package com.example.pizzashopapplication.presentation.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.pizzashopapplication.R
import com.example.pizzashopapplication.data.model.Dishe
import com.example.pizzashopapplication.databinding.CardMenuBinding
import com.example.pizzashopapplication.domain.DomainDish
import com.squareup.picasso.Picasso

class MenuAdapter : ListAdapter<DomainDish, MenuViewHolder>(MenuDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = CardMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val item = getItem(position)

        with(holder.binding) {
            tvCardPrice.text = "От ${item.price.toString()} р"

            tvCardContent.text = item.description
            tvCardLabel.text = item.name
            Picasso.get().load(item.image_url).into(imageView)

        }
    }
}