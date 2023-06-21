package com.example.pizzashopapplication.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.pizzashopapplication.R
import com.example.pizzashopapplication.databinding.CardChipBinding

class BannerAdapter : ListAdapter<Int, BannerViewHolder>(BannerDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val binding = CardChipBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BannerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        holder.binding.banner.setImageResource(R.drawable.rectangle_chip)
    }
}