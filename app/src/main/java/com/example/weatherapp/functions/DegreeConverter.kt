package com.example.weatherapp.functions

class DegreeConverter {
    val KELVIN_TO_CELSIUS_CONVERSION = 273.15

    fun KelvintoCelsius(kelvin: Double): Double {
        val celsius = kelvin - KELVIN_TO_CELSIUS_CONVERSION
        return celsius
    }

    fun KelvintoFahrenheit(kelvin: Double): Double {
        val fahrenheit = (kelvin - KELVIN_TO_CELSIUS_CONVERSION) * 1.8 + 32
        return fahrenheit
    }

    fun CelsiustoKelvin(celsius: Double): Double {
        val kelvin = celsius + KELVIN_TO_CELSIUS_CONVERSION
        return kelvin
    }

    fun CelsiustoFahrenheit(celsius: Double): Double {
        val fahrenheit = celsius * 1.8 + 32
        return fahrenheit
    }

    fun FahrenheittoCelsius(fahrenheit: Double): Double {
        val celsius = (fahrenheit - 32) / 1.8
        return celsius
    }

    fun FahrenheittoKelvin(fahrenheit: Double): Double {
        val celsius = (fahrenheit - 32) / 1.8
        val kelvin = celsius + KELVIN_TO_CELSIUS_CONVERSION
        return kelvin
    }
}
