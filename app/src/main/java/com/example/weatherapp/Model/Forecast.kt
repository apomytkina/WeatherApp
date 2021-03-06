package com.example.weatherapp.Model

import com.example.weatherapp.Model.Data
import com.google.gson.annotations.SerializedName

data class Forecast(
    val city_name: String,
    val country_code: String,
    val `data`: List<Data>,
    val lat: String,
    val lon: String,
    val state_code: String,
    val timezone: String
)