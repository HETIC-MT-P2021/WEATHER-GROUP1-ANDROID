package com.example.weather_group1_android.network.models


import com.google.gson.annotations.SerializedName

data class WeatherAsset(
    @SerializedName("city")
    val city: WeatherAssetCity,
    @SerializedName("cnt")
    val cnt: Int,
    @SerializedName("cod")
    val cod: String,
    @SerializedName("list")
    val list: List<WeatherAssetList>,
    @SerializedName("message")
    val message: Int
)