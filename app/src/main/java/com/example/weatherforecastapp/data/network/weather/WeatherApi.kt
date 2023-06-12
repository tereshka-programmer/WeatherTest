package com.example.weatherforecastapp.data.network.weather

import com.example.weatherforecastapp.data.network.NetworkConstants
import com.example.weatherforecastapp.data.network.weather.entities.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("forecast.json")
    suspend fun getWeather(
        @Query("key") key: String = NetworkConstants.WEATHER_API_KEY,
        @Query("q") q: String = "minsk",
        @Query("days") days: String = "3",
        @Query("aqi") aqi: String = "no",
        @Query("alerts") alerts: String = "no"
    ): WeatherResponse


}