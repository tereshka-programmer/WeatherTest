package com.example.weatherforecastapp.ui.search.controller

import com.airbnb.epoxy.AsyncEpoxyController
import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.TypedEpoxyController
import com.example.weatherforecastapp.ui.search.CitiesObject
import com.example.weatherforecastapp.ui.search.CityModel

interface Listener {
    fun sendCity(city: String)
}

class CitiesController : EpoxyController() {

    var cities = emptyList<String>()
        set(value) {
            field = value
            requestModelBuild()
        }

    init {
        cities = CitiesObject.listOfCities
    }

    override fun buildModels() {
        cities.forEach {
            //
        }
    }
}