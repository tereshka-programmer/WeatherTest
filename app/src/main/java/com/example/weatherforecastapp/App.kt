package com.example.weatherforecastapp

import android.app.Application
import com.airbnb.epoxy.Carousel
import com.airbnb.mvrx.Mavericks
import com.airbnb.mvrx.MavericksViewModelConfigFactory
import com.example.weatherforecastapp.domain.repository.WeatherRepository
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App : Application() {

    @Inject lateinit var weatherRepository: WeatherRepository
    override fun onCreate() {
        super.onCreate()
        Mavericks.initialize(this, MavericksViewModelConfigFactory(applicationContext))
        Carousel.setDefaultGlobalSnapHelperFactory(null)
    }
}