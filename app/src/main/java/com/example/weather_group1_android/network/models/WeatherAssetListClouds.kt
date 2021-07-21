package com.example.weather_group1_android.network.models


import com.google.gson.annotations.SerializedName

data class WeatherAssetListClouds(
    @SerializedName("all")
    val all: Int
)