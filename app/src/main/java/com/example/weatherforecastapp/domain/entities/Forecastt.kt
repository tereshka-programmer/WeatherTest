package com.example.weatherforecastapp.domain.entities

data class Forecastt(
    val cityName: String,
    val currentForecast: CurrentForecast,
    val daysForecast: List<DayForecast>,
)
