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
    @GET("data/2.5/forecast?")
    suspend fun assets(@Query("q") q: String,
                       @Query("lang") lang: String,
                       @Query("units") units: String,
                       @Query("APPID") app_id: String)
    : Response<WeatherAsset>
}
