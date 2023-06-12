package com.example.weatherforecastapp.data.network.weather.entities

data class Current(
    val condition: Condition,
    val humidity: Int,
    val temp_f: Double,
    val wind_mph: Double
)