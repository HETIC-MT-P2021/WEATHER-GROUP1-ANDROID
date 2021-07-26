package com.example.weather_group1_android.network.services

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.example.weather_group1_android.network.models.WeatherAsset
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * This class allows to build our services with retrofit and interface.
 * */
class WeatherServiceBuilder {
    companion object {
        const val baseUrl = "https://api.openweathermap.org/"
        const val q = "Paris,fr"
        const val lang = "fr"
        const val units = "metric"
        const val AppId  = "e3e53a88fe0338f43a52da7aee06e41c"
    }

    /**
     * Allows to check the network status
     * */
    fun isNetworkAvailable(context: Context) =
        (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).run {
            getNetworkCapabilities(activeNetwork)?.run {
                hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                        hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                        hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
            } ?: false
        }

    /**
     * Configure and return and retrofit instance
     * */
    private fun getRetrofit(): Retrofit {
        val okBuilder = OkHttpClient().newBuilder().apply {
            connectTimeout(60, TimeUnit.SECONDS)
            callTimeout(60, TimeUnit.SECONDS)
            readTimeout(60, TimeUnit.SECONDS)
            writeTimeout(60, TimeUnit.SECONDS)
        }
        return  Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okBuilder.build())
            .build()
    }

    /**
     * Allows the service to be consumed asynchronously
     * */
    suspend fun getAssets(): Response<WeatherAsset> = getRetrofit().create(WeatherService::class.java)
        .assets(q, lang, units, AppId)
}
