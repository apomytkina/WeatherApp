package com.example.weatherapp.Model

data class Data(
    val app_max_temp: Double,
    val app_min_temp: Double,
    val clouds: Double, // Int
    val clouds_hi: Double, // Int
    val clouds_low: Double, // Int
    val clouds_mid: Double, // Int
    val datetime: String,
    val dewpt: Double,
    val high_temp: Double,
    val low_temp: Double,
    val max_dhi: Any,
    val max_temp: Double,
    val min_temp: Double,
    val moon_phase: Double,
    val moon_phase_lunation: Double,
    val moonrise_ts: Double, // Int
    val moonset_ts: Double, // Int
    val ozone: Double,
    val pop: Double, // Int
    val precip: Double, // Int
    val pres: Double,
    val rh: Double, // Int
    val slp: Double,
    val snow: Double,// Int
    val snow_depth: Double, // Int
    val sunrise_ts: Double, // Int
    val sunset_ts: Double, // Int
    val temp: Double,
    val ts: Double, // Int
    val uv: Double,
    val valid_date: String,
    val vis: Double,
    val weather: Weather,
    val wind_cdir: String,
    val wind_cdir_full: String,
    val wind_dir: Double, // Int
    val wind_gust_spd: Double,
    val wind_spd: Double
)