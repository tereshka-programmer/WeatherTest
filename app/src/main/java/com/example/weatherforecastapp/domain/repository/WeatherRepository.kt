package com.example.weatherforecastapp.domain.repository

import com.example.weatherforecastapp.domain.common.StatusOfResponse
import com.example.weatherforecastapp.domain.entities.Forecastt
import kotlinx.coroutines.flow.SharedFlow

interface WeatherRepository {

    val weatherForecastFlow: SharedFlow<Forecastt>

    suspend fun getWeatherForecast(city: String) : StatusOfResponse

}