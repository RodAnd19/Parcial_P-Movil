package com.andres.festival_app.ui.festival.listfestivals.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.andres.festival_app.data.model.FestivalModel
import com.andres.festival_app.databinding.FestivalItemBinding

class FestivalRecyclerViewHolder (private val binding : FestivalItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(festival : FestivalModel, clickListener : (FestivalModel) -> Unit) {
        binding.nameFestivalTv.text = festival.name
        binding.placeFestivalTv.text = festival.place

        binding.festivalCardView.setOnClickListener {
            clickListener(festival)
        }
    }
}