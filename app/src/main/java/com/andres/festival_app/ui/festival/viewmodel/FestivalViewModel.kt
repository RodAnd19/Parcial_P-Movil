package com.andres.festival_app.ui.festival.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.andres.festival_app.FestivalReviewerApplication
import com.andres.festival_app.data.festivals
import com.andres.festival_app.data.model.FestivalModel
import com.andres.festival_app.repositories.FestivalRepository

class FestivalViewModel (private val repository : FestivalRepository) : ViewModel() {

    // Live Data Variables
    var name = MutableLiveData("")
    var place = MutableLiveData("")
    var status = MutableLiveData("")

    // Functions
    fun getFestivals() = repository.getFestivals()

    fun addFestivals(festival: FestivalModel) = repository.addFestivals(festival)

    fun createFestival() {
        if (!validateData()) {
            status.value = WRONG_INFORMATION
            return
        }

        val festival = FestivalModel(
            name.value!!,
            place.value!!
        )

        addFestivals(festival)
        clearData()

        status.value = FESTIVAL_CREATED

    }

    private fun validateData() : Boolean {
        when {
            name.value.isNullOrEmpty() -> return false
            place.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun clearData() {
        name.value = ""
        place.value = ""
    }

    fun clearStatus() {
        status.value = INACTIVE
    }

    fun setSelectedFestival(festival : FestivalModel) {
        name.value = festival.name
        place.value = festival.place
    }

    // Global Variables
    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as FestivalReviewerApplication
                FestivalViewModel(app.festivalRepository)
            }
        }

        const val FESTIVAL_CREATED = "Festival Created Done :)"
        const val WRONG_INFORMATION = "Write Some Info :("
        const val INACTIVE = ""

    }
}