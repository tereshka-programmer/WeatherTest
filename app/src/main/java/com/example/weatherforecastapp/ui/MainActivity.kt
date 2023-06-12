package com.example.weatherforecastapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.weatherforecastapp.R
import com.example.weatherforecastapp.domain.repository.WeatherRepository
import com.example.weatherforecastapp.ui.main.MainFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var repositry: WeatherRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fragment = MainFragment()
        Log.d("TESTTTT", fragment.toString())

        supportFragmentManager.beginTransaction().add(R.id.fragmentContainerView, fragment).commit()

//        GlobalScope.launch {
//            val rep = repositry.getWeatherForecast("Minsk")
//            Log.d("TESTTTT", rep.status)
//        }
    }
}