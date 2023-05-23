package com.andres.festival_app.repositories

import com.andres.festival_app.data.model.FestivalModel

class FestivalRepository (private val festivals : MutableList<FestivalModel>) {

    fun getFestivals() = festivals

    fun addFestivals(newFestival : FestivalModel) = festivals.add(newFestival)
}