package com.example.weatherforecastapp.data.network.weather.entities

data class Forecastday(
    val date: String,
    val day: Day,
    val condition: Condition?,
)