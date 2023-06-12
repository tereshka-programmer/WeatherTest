package com.example.weatherforecastapp.ui.main

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.Uninitialized
import com.example.weatherforecastapp.domain.entities.Forecastt

data class WeatherState(
    val forecastt: Async<Forecastt> = Uninitialized,
    val error: String = "",
    val inProgress: Boolean = true,
) : MavericksState