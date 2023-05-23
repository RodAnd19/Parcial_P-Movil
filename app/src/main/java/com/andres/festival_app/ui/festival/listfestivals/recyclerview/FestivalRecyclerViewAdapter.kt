package com.andres.festival_app.ui.festival.listfestivals.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andres.festival_app.data.model.FestivalModel
import com.andres.festival_app.databinding.FestivalItemBinding


class FestivalRecyclerViewAdapter (
    private val clickListener : (FestivalModel) -> Unit
) : RecyclerView.Adapter<FestivalRecyclerViewHolder>() {

    private val festivals = ArrayList<FestivalModel>()

    // Se encargara de inflar las vistas.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FestivalRecyclerViewHolder {
        val binding = FestivalItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FestivalRecyclerViewHolder(binding)
    }

    // Devuelve el num de elementos que hay en la lista.
    override fun getItemCount() : Int {
        return festivals.size
    }

    // Lleva el orden coherente de la lista.
    override fun onBindViewHolder(holder: FestivalRecyclerViewHolder, position: Int) {
        val festival = festivals[position]
        holder.bind(festival, clickListener)
    }

    // Actualiza la lista de datos, primero los elimina y luego los setea.
    fun setData(festivalList : List<FestivalModel>) {
        festivals.clear()
        festivals.addAll(festivalList)
    }

}