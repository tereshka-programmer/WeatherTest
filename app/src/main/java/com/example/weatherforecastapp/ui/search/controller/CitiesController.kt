package com.example.weatherforecastapp.ui.search.controller

import com.airbnb.epoxy.AsyncEpoxyController
import com.airbnb.epoxy.EpoxyController
import com.example.weatherforecastapp.ui.search.CityItemHolder

class CitiesController : AsyncEpoxyController() {

    var cities = emptyList<String>()
        set(value) {
            field = value
            requestModelBuild()
        }


    override fun buildModels() {
        cities.forEach { cityName ->

        }
    }
}