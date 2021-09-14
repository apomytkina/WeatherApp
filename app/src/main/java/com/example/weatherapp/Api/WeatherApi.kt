package com.example.weatherapp.Api

import androidx.lifecycle.LiveData
import com.example.weatherapp.Util.Constants.API_KEY
import com.example.weatherapp.Model.CurrentWeather
import com.example.weatherapp.Model.Forecast
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherApi {
    @GET("/v2.0/forecast/daily")
    suspend fun getForecast(
        @Query("city")
        city: String = "Moscow",
        @Query("key")
        key: String = API_KEY
    ): Response<Forecast>

    @GET("/v2.0/current")
    suspend fun getCurrentWeather(
        @Query("city")
        city: String = "Moscow",
        @Query("key")
        key: String = API_KEY
    ) : Response<CurrentWeather>
}