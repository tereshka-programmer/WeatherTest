package com.example.weatherforecastapp.domain.entities

data class CurrentForecast (
    val temperature: Double,
    val windMph: Double,
    val humidity: Int,
    val currentConditionIcon: String,
    val currentConditionText: String,
)