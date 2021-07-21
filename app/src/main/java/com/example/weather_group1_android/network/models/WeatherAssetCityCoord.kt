package com.example.weather_group1_android.network.models


import com.google.gson.annotations.SerializedName

data class WeatherAssetCityCoord(
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lon")
    val lon: Double
)