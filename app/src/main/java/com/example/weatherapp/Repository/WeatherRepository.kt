package com.example.weatherapp.Repository

import androidx.lifecycle.LiveData
import com.example.weatherapp.Api.WeatherApi
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val weatherApi: WeatherApi
) {
    suspend fun getCurrentWeather(cityName:String) = weatherApi.getCurrentWeather(city = cityName)
    suspend fun getForecast(cityName: String) = weatherApi.getForecast(city = cityName)
}