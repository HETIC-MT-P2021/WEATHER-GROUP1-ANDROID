package com.example.weather_group1_android.network.ui
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.weather_group1_android.databinding.ActivityMainBinding
import com.example.weather_group1_android.network.models.WeatherAsset
import com.example.weather_group1_android.network.services.WeatherServiceBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val WeatherService by lazy {
        WeatherServiceBuilder()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadAssets()
    }

    private fun loadAssets() {
        if(!WeatherService.isNetworkAvailable(this)) {
            displayError()
            return
        }
        CoroutineScope(Dispatchers.IO).launch {
            val response = WeatherService.getAssets()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    displayResults(response.body())
                } else {
                    displayError()
                }
            }
        }
    }
    private fun displayResults(response: WeatherAsset?) {
        response?.let {
            binding.temp.text = (response.list[0].main.temp.toInt()).toString() + "°C"
        }
    }
    private fun displayError() {
        Toast.makeText(this, "Error loading assets from CoinCap API", Toast.LENGTH_LONG).show()
    }
}
