package com.example.weatherforecastapp.ui.main

import android.util.Log
import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.example.weatherforecastapp.App
import com.example.weatherforecastapp.data.network.NetworkConstants
import com.example.weatherforecastapp.domain.common.Constants

import com.example.weatherforecastapp.domain.repository.WeatherRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.android.internal.lifecycle.HiltViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import javax.inject.Inject


class WeatherViewModel (
    val weatherRepository: WeatherRepository,
    state: WeatherState,
) : MavericksViewModel<WeatherState>(state) {

    init {
        viewModelScope.launch {
            weatherRepository.weatherForecastFlow.execute {
                copy(forecastt = it)
            }
        }
    }

    suspend fun send(city: String) {
        val status = weatherRepository.getWeatherForecast(city)
        if (status.status != Constants.STATE_OK) {
            setState {
                copy(error = status.status, inProgress = false)
            }
        }
        setState {
            copy(inProgress = false, error = "")
        }
        Log.d("TESTTTTT", status.status.toString())
    }

    //interface Factory :
  //  interface Factory : Assisted

//    @AssistedFactory
//    interface Factory : AssistedViewModelFactory<WeatherViewModel, WeatherState> {
//        override fun create(state: WeatherState): WeatherViewModel
//    }
//
//    companion object : MavericksViewModelFactory<WeatherViewModel, WeatherState> by hiltMavericksViewModelFactory()
    companion object : MavericksViewModelFactory<WeatherViewModel, WeatherState> {
        override fun create(
            viewModelContext: ViewModelContext,
            state: WeatherState
        ): WeatherViewModel? {
 //           @Inject val repository: WeatherRepository
//            val weatherRepository: WeatherRepository = EntryPoints.get(viewModelContext.activity.applicationContext, WeatherRepository::class.java)
         //   val weatherRepository = EntryPointAccessors.fromApplication(viewModelContext.activity.applicationContext, WeatherRepository::class.java)
            val weatherRepository = viewModelContext.app<App>().weatherRepository
            return WeatherViewModel(weatherRepository, state)
        }
    }

}