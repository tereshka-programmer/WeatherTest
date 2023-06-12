package com.example.weatherforecastapp.domain.entities

data class DayForecast(
    val date: String,
    val avgTemperatureC: Double,
    val avgTemperatureF: Double,
    val conditionIcon: String,
    val conditionText: String
)
