package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.weatherapp.apicalls.API
import com.example.weatherapp.constants.Constants.BASE_URL
import com.example.weatherapp.functions.DegreeConverter
import com.example.weatherapp.retrofit.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiKey = BuildConfig.GOOGLE_PLACE_API_KEY
        val quotesApi = RetrofitInstance().retrofitGetInstance().create(API::class.java)
        val textView = findViewById<TextView>(R.id.textView)
        var countryName = ""

        GlobalScope.launch {
            val result = quotesApi.getWeather(41.02,29.17, apiKey)

            if (result != null){
                val country = result.body()?.name
                if (country != null){
                    withContext(Dispatchers.Main){
                        val name = result.body()?.name.toString()
                        textView.setText(name)
                        val temp = result.body()?.main?.temp

                        if (temp != null) {
                            val tempCelsius = DegreeConverter().KelvintoCelsius(temp).toFloat().toString()
                            textView.append(tempCelsius)
                        }

                    }

                }
            }
        }

    }
}