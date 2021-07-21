package com.example.weather_group1_android.network.models


import com.google.gson.annotations.SerializedName

data class WeatherAssetListSys(
    @SerializedName("pod")
    val pod: String
)