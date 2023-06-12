package com.example.weatherforecastapp.data.network.weather

import android.util.Log
import com.example.weatherforecastapp.data.network.base.BaseRetrofitSource
import com.example.weatherforecastapp.data.network.base.RetrofitConfig
import com.example.weatherforecastapp.data.network.weather.entities.WeatherResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitWeatherSource @Inject constructor (
    config: RetrofitConfig
) : BaseRetrofitSource(config), WeatherSource {

    private val weatherApi = retrofit.create(WeatherApi::class.java)

    override suspend fun getWeatherFromApi(city: String): WeatherResponse = wrapRetrofitExceptions {
        val response = weatherApi.getWeather(q = city)
        Log.d("TESTTTT", " RESONSE : ${response.toString()}")
        return@wrapRetrofitExceptions response
    }

}