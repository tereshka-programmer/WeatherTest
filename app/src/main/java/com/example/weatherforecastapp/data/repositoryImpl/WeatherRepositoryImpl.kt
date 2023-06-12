package com.example.weatherforecastapp.data.repositoryImpl

import android.util.Log
import com.example.weatherforecastapp.data.network.weather.WeatherSource
import com.example.weatherforecastapp.domain.common.*
import com.example.weatherforecastapp.domain.entities.Forecastt
import com.example.weatherforecastapp.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepositoryImpl @Inject constructor(
    private val weatherSource: WeatherSource
) : WeatherRepository {

    private val _weatherForecastFlow = MutableSharedFlow<Forecastt>()
    override val weatherForecastFlow: SharedFlow<Forecastt> = _weatherForecastFlow

    override suspend fun getWeatherForecast(city: String) : StatusOfResponse {
        val response = try {
            weatherSource.getWeatherFromApi(city).toForecastt()
        } catch (e: ParseBackendResponseException) {
            return StatusResponse("Error that we will fix nearly")
        } catch (e: BackendException) {
            return StatusResponse("Error : ${e.code}")
        } catch (e: ConnectionException) {
            return StatusResponse("Connection is not available")
        }
        Log.d("TESTTTTT", response.toString())
        _weatherForecastFlow.emit(response)
        return StatusResponse(Constants.STATE_OK)
    }
}