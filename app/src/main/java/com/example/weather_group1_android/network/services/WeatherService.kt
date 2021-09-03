package com.example.weather_group1_android.network.services

import com.example.weather_group1_android.network.models.WeatherAsset
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

/**
 * It is an interface that contains the assets() function,
 * which returns the API data using a retrofit call function.
 * */
interface WeatherService {
    @Headers("Content-type: application/json")
    @GET("data/2.5/onecall?")
    suspend fun assets(@Query("lat") lat: String,
                       @Query("lon") lon: String,
                       @Query("units") units: String,
                       @Query("exclude") exclude: String,
                       @Query("APPID") app_id: String)
    : Response<WeatherAsset>
}
