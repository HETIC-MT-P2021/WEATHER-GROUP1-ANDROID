package com.example.weather_group1_android.network.models


import com.google.gson.annotations.SerializedName

data class WeatherAssetList (
    @SerializedName("clouds")
    val clouds: WeatherAssetListClouds,
    @SerializedName("dt")
    val dt: Int,
    @SerializedName("dt_txt")
    val dtTxt: String,
    @SerializedName("main")
    val main: WeatherAssetListMain,
    @SerializedName("pop")
    val pop: Float,
    @SerializedName("sys")
    val sys: WeatherAssetListSys,
    @SerializedName("visibility")
    val visibility: Int,
    @SerializedName("weather")
    val weather: List<WeatherAssetListWeather>,
    @SerializedName("wind")
    val wind: WeatherAssetListWind
)
