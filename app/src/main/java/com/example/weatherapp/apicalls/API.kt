package com.example.weatherapp.apicalls

import com.example.weatherapp.response.currentweather.CurrentWeather
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Query

interface API {
    @GET("/data/2.5/weather")
    suspend fun getWeather(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("appid") apiKey: String?,
        @Query("lang") lang: String = "tr"
    ): Response<CurrentWeather>
}