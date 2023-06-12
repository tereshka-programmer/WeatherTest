package com.example.weatherforecastapp.data.network.weather

import com.example.weatherforecastapp.data.network.weather.entities.WeatherResponse

interface WeatherSource {

    suspend fun getWeatherFromApi(city: String): WeatherResponse

}