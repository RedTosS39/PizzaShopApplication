package com.example.pizzashopapplication.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.pizzashopapplication.databinding.ActivityMainBinding
import com.example.pizzashopapplication.databinding.CardMenuBinding
import com.example.pizzashopapplication.databinding.FragmentMainBinding

class MenuAdapter : ListAdapter<String, MenuViewHolder>(MenuDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = CardMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val item = getItem(position)
            holder.binding.tvCardPrice.text = "AAAA"
    }
}