package com.example.weatherapp.Repository

import com.example.weatherapp.Api.WeatherApi
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val weatherApi: WeatherApi
) {
    suspend fun getCurrentWeather() = weatherApi.getCurrentWeather()
    suspend fun getForecast() = weatherApi.getForecast()
}