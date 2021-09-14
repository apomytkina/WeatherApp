package com.example.weatherapp.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.Model.CurrentWeather
import com.example.weatherapp.Model.Forecast
import com.example.weatherapp.Repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val cityName: String,
    private val weatherRepository: WeatherRepository,
) : ViewModel() {
    private val _forecast = MutableLiveData<Forecast>()
    val forecast: LiveData<Forecast> = _forecast

    private val _currentWeather = MutableLiveData<CurrentWeather>()
    val currentWeather: LiveData<CurrentWeather> = _currentWeather

    fun getCurrentWeather(city: String) = viewModelScope.launch {
            weatherRepository.getCurrentWeather(city).let { response ->
                if (response.isSuccessful && response.body() != null)
                    _currentWeather.postValue(response.body())
                else
                    Log.d("tag", "getCurrentWeather Error: ${response.code()}")
            }
        }

    fun getForecast(city: String) = viewModelScope.launch {
        weatherRepository.getForecast(city).let { response ->
            if (response.isSuccessful && response.body() != null)
                _forecast.postValue(response.body())
            else
                Log.d("tag", "getForecast Error: ${response.code()}")
        }
    }

    init {
        getCurrentWeather(cityName)
        getForecast(cityName)
    }
}