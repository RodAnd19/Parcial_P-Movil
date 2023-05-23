package com.andres.festival_app

import android.app.Application
import com.andres.festival_app.data.festivals
import com.andres.festival_app.repositories.FestivalRepository

class FestivalReviewerApplication : Application() {

    val festivalRepository : FestivalRepository by lazy {
        FestivalRepository(festivals)
    }
}