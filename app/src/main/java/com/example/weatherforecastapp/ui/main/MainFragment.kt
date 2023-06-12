package com.example.weatherforecastapp.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MavericksView
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.bumptech.glide.Glide
import com.example.weatherforecastapp.R
import com.example.weatherforecastapp.databinding.FragmentMainBinding
import com.example.weatherforecastapp.domain.common.Constants
import com.example.weatherforecastapp.domain.entities.Forecastt
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main), MavericksView {

    private val viewModel: WeatherViewModel by fragmentViewModel()
    private lateinit var binding: FragmentMainBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)


        lifecycleScope.launchWhenCreated {
            viewModel.send("minsk")
        }

        viewModel.onAsync(WeatherState::forecastt, onSuccess =  {
            Log.d("TESTTTTT", "FORECAST ASYNC " + it.toString())
            renderMainState(it)
        })

        viewModel.onEach(WeatherState::error) {
            renderError(error = it)
        }
    }

    override fun invalidate() = withState(viewModel) {
        renderInProgress(it.inProgress)
        renderError(it.error)
        // renderMainState(it.forecastt)
    }


    @SuppressLint("StringFormatMatches")
    private fun renderMainState(forecastt: Forecastt) {

        binding.tvCityName.text = forecastt.cityName
        binding.tvDate.text = forecastt.daysForecast[0].date
        binding.tvTemperature.text = requireContext().getString(R.string.currentTemp, forecastt.currentForecast.temperature.toString())
        binding.tvCondition.text = forecastt.currentForecast.currentConditionText
        binding.tvWild.text = requireContext().getString(R.string.currentWild, forecastt.currentForecast.windMph.toString())
        binding.tvHumidity.text = requireContext().getString(R.string.humidity, forecastt.currentForecast.humidity.toString())
        binding.tvTempFirst.text = requireContext().getString(R.string.tempForDays, forecastt.daysForecast[0].avgTemperatureC.toString(), forecastt.daysForecast[0].avgTemperatureF.toString())
        binding.tvTempSecond.text = requireContext().getString(R.string.tempForDays, forecastt.daysForecast[1].avgTemperatureC.toString(), forecastt.daysForecast[1].avgTemperatureF.toString())
        binding.tvTempThird.text = requireContext().getString(R.string.tempForDays, forecastt.daysForecast[2].avgTemperatureC.toString(), forecastt.daysForecast[2].avgTemperatureF.toString())
        Glide.with(requireContext())
            .load(forecastt.currentForecast.currentConditionIcon)
            .centerCrop()
            .error(R.drawable.weather_placeholder)
            .placeholder(R.drawable.weather_placeholder)
            .into(binding.imgCondition)

    }

    private fun log(string: String) {
        Log.d("TESTTTTT", "ERROR FROM")
    }

    private fun renderError(error: String) {
        if (error != "" && error != Constants.STATE_OK) {
            binding.tvError.text = error
            binding.mainStateFrame.visibility = View.GONE
            binding.tvError.visibility = View.VISIBLE
        }
    }

    private fun renderInProgress(value: Boolean) {
        if (value) {
            binding.progressBar.visibility = View.VISIBLE
            binding.mainStateFrame.visibility = View.GONE
        } else {
            binding.progressBar.visibility = View.GONE
            binding.mainStateFrame.visibility = View.VISIBLE
        }
    }

//    override fun invalidate() {
//        viewModel.onAsync()
//    }
}