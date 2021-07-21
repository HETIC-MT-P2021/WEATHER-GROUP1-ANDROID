package com.example.weather_group1_android.network.models


import com.google.gson.annotations.SerializedName

data class WeatherAssetCity(
    @SerializedName("coord")
    val coord: WeatherAssetCityCoord,
    @SerializedName("country")
    val country: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("population")
    val population: Int,
    @SerializedName("sunrise")
    val sunrise: Int,
    @SerializedName("sunset")
    val sunset: Int,
    @SerializedName("timezone")
    val timezone: Int
)