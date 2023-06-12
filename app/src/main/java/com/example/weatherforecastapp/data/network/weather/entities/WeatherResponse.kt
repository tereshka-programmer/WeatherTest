package com.example.weatherforecastapp.data.network.weather.entities

import com.example.weatherforecastapp.domain.entities.CurrentForecast
import com.example.weatherforecastapp.domain.entities.DayForecast
import com.example.weatherforecastapp.domain.entities.Forecastt

data class WeatherResponse(
    val current: Current,
    val forecast: Forecast,
    val location: Location
) {
    fun toForecastt() = Forecastt(
        cityName = location.name,
        currentForecast = CurrentForecast(
            temperature = current.temp_f,
            windMph = current.wind_mph,
            humidity = current.humidity,
            currentConditionIcon = current.condition.icon,
            currentConditionText = current.condition.text
        ),
        daysForecast = forecast.forecastday.map { forecastday ->
            DayForecast(
                date = forecastday.date,
                avgTemperatureC = forecastday.day.avgtemp_c,
                avgTemperatureF = forecastday.day.avgtemp_f,
                conditionIcon = forecastday.condition?.icon ?: "",
                conditionText = forecastday.condition?.text ?: ""
            )
        }
    )
}