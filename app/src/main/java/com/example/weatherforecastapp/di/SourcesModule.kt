package com.example.weatherforecastapp.di

import com.example.weatherforecastapp.data.network.weather.RetrofitWeatherSource
import com.example.weatherforecastapp.data.network.weather.WeatherSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SourcesModule {

    @Binds
    abstract fun bindWeatherSource(
        retrofitWeatherSource: RetrofitWeatherSource
    ): WeatherSource

}