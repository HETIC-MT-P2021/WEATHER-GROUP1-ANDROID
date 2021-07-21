package com.example.weather_group1_android.network.models


import com.google.gson.annotations.SerializedName

data class WeatherAssetListWind(
    @SerializedName("deg")
    val deg: Int,
    @SerializedName("gust")
    val gust: Double,
    @SerializedName("speed")
    val speed: Double
)