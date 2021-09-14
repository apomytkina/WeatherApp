package com.example.weatherapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.Repository.WeatherRepository
import com.example.weatherapp.ViewModel.WeatherViewModel

class WeatherViewModelFactory(
    private val cityName : String,
    private val weatherRepository: WeatherRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return WeatherViewModel(weatherRepository) as T
    }
}