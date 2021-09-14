package com.example.weatherapp.UI

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.weatherapp.R
import com.example.weatherapp.Repository.WeatherRepository
import com.example.weatherapp.ViewModel.WeatherViewModel
import com.example.weatherapp.WeatherViewModelFactory
import com.example.weatherapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject lateinit var weatherRepository: WeatherRepository

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: WeatherViewModel
    lateinit var weatherViewModelFactory: WeatherViewModelFactory

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        weatherViewModelFactory =
            WeatherViewModelFactory(binding.editText.text.toString(), weatherRepository)
        viewModel =
            ViewModelProvider(this, weatherViewModelFactory).get(WeatherViewModel::class.java)

        var job: Job? = null
        binding.editText.addTextChangedListener{ editable ->
            job?.cancel()
            job = MainScope().launch {
                delay(3000L)
                editable?.let {
                    if (editable.toString().isNotEmpty()){
                        viewModel.getCurrentWeather(editable.toString())
                        viewModel.getForecast(editable.toString())
                    }
                }
            }
        }

        lifecycleScope.launch{
            viewModel.currentWeather.observe(this@MainActivity, { weather ->
                binding.apply {
                    tvDescription.text = weather.data[0].weather.description
                    tvTemperature.text = "${weather.data[0].temp.toInt()} ℃"
                    tvWindSpeed.text = "${weather.data[0].wind_spd.toInt()} km/h"
                }
            })

            viewModel.forecast.observe(this@MainActivity, { forecast ->
                binding.apply {
                    tvCity.text = forecast.city_name

                    tvDayOfWeek1.text = LocalDate.now().plusDays(1).dayOfWeek.name.lowercase()
                    tvTemperature1.text = "${forecast.data[0].temp.toInt().toString()} ℃"

                    tvDayOfWeek2.text = LocalDate.now().plusDays(2).dayOfWeek.name.lowercase()
                    tvTemperature2.text = "${forecast.data[1].temp.toInt().toString()} ℃"
                    tvTemperature.text[0].uppercase()

                    tvDayOfWeek3.text = LocalDate.now().plusDays(3).dayOfWeek.name.lowercase()
                    tvTemperature3.text = "${forecast.data[2].temp.toInt().toString()} ℃"

                    tvDayOfWeek4.text = LocalDate.now().plusDays(4).dayOfWeek.name.lowercase()
                    tvTemperature4.text = "${forecast.data[3].temp.toInt().toString()} ℃"

                    tvDayOfWeek5.text = LocalDate.now().plusDays(5).dayOfWeek.name.lowercase()
                    tvTemperature5.text = "${forecast.data[4].temp.toInt().toString()} ℃"

                    tvDayOfWeek6.text = LocalDate.now().plusDays(6).dayOfWeek.name.lowercase()
                    tvTemperature6.text = "${forecast.data[5].temp.toInt().toString()} ℃"
                }
            })
        }
    }
}