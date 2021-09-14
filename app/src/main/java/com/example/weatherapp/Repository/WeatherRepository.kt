package com.example.weatherapp.Repository

import com.example.weatherapp.Api.WeatherApi
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val weatherApi: WeatherApi
) {
    suspend fun getCurrentWeather(cityName:String) = weatherApi.getCurrentWeather(cityName)
    suspend fun getForecast(cityName: String) = weatherApi.getForecast(cityName)
}