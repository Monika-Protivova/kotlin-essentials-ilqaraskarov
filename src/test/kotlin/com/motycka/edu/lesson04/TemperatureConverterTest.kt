package com.motycka.edu.lesson04
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.doubles.plusOrMinus // For float comparisons with tolerance
import io.kotest.matchers.shouldBe

class TemperatureConverterTest : StringSpec({

    "toFahrenheit should convert 0 Celsius to 32 Fahrenheit" {
        // given
        val celsius = 0.0
        // when
        val fahrenheit = TemperatureConverter.toFahrenheit(celsius)
        // then
        fahrenheit shouldBe 32.0
    }

    "toFahrenheit should convert 100 Celsius to 212 Fahrenheit" {
        val celsius = 100.0
        val fahrenheit = TemperatureConverter.toFahrenheit(celsius)
        fahrenheit shouldBe 212.0
    }

    "toFahrenheit should convert -40 Celsius to -40 Fahrenheit" {
        val celsius = -40.0
        val fahrenheit = TemperatureConverter.toFahrenheit(celsius)
        fahrenheit shouldBe -40.0
    }


    "toCelsius should convert 32 Fahrenheit to 0 Celsius" {
        val fahrenheit = 32.0
        val celsius = TemperatureConverter.toCelsius(fahrenheit)
        celsius shouldBe 0.0
    }

    "toCelsius should convert 212 Fahrenheit to 100 Celsius" {
        val fahrenheit = 212.0
        val celsius = TemperatureConverter.toCelsius(fahrenheit)
        celsius shouldBe 100.0
    }

    "toCelsius should convert 98.6 Fahrenheit to 37 Celsius" {
        val fahrenheit = 98.6
        val celsius = TemperatureConverter.toCelsius(fahrenheit)
        celsius shouldBe 37.0
    }

    "toCelsius should convert -40 Fahrenheit to -40 Celsius (a negative Fahrenheit value)" {
        val fahrenheit = -40.0
        val celsius = TemperatureConverter.toCelsius(fahrenheit)
        celsius shouldBe -40.0
    }


    "toCelsius should handle very large Fahrenheit values" {
        val fahrenheit = 1000000.0 // 1 million °F
        val celsius = TemperatureConverter.toCelsius(fahrenheit)
        val expectedCelsius = (1000000.0 - 32.0) * 5.0 / 9.0
        celsius shouldBe (expectedCelsius plusOrMinus 0.00001) // Use tolerance for potential floating point inaccuracies
    }

    "toCelsius should handle very small (large negative) Fahrenheit values" {
        val fahrenheit = -1000000.0
        val celsius = TemperatureConverter.toCelsius(fahrenheit)
        val expectedCelsius = (-1000000.0 - 32.0) * 5.0 / 9.0
        celsius shouldBe (expectedCelsius plusOrMinus 0.00001)
    }

    "toFahrenheit should handle very large Celsius values" {
        val celsius = 500000.0
        val fahrenheit = TemperatureConverter.toFahrenheit(celsius)
        val expectedFahrenheit = 500000.0 * 9.0 / 5.0 + 32.0
        fahrenheit shouldBe (expectedFahrenheit plusOrMinus 0.00001)
    }

    "toFahrenheit should handle very small (large negative) Celsius values" {
        val celsius = -500000.0
        val fahrenheit = TemperatureConverter.toFahrenheit(celsius)
        val expectedFahrenheit = -500000.0 * 9.0 / 5.0 + 32.0
        fahrenheit shouldBe (expectedFahrenheit plusOrMinus 0.00001)
    }

    "round-trip conversion: Celsius to Fahrenheit and back to Celsius should preserve the original value" {
        val originalCelsius = 25.75
        val tolerance = 0.000000001

        val fahrenheit = TemperatureConverter.toFahrenheit(originalCelsius)
        val resultCelsius = TemperatureConverter.toCelsius(fahrenheit)
        resultCelsius shouldBe (originalCelsius plusOrMinus tolerance)

        val anotherOriginalCelsius = 10.0 / 3.0
        val fahrenheitFromRecurring = TemperatureConverter.toFahrenheit(anotherOriginalCelsius)
        val resultCelsiusFromRecurring = TemperatureConverter.toCelsius(fahrenheitFromRecurring)
        resultCelsiusFromRecurring shouldBe (anotherOriginalCelsius plusOrMinus tolerance)
    }
    "round-trip conversion: Fahrenheit to Celsius and back to Fahrenheit should preserve the original value" {
        val originalFahrenheit = 77.45
        val tolerance = 0.000000001
        val celsius = TemperatureConverter.toCelsius(originalFahrenheit)
        val resultFahrenheit = TemperatureConverter.toFahrenheit(celsius)
        resultFahrenheit shouldBe (originalFahrenheit plusOrMinus tolerance)
        val anotherOriginalFahrenheit = 80.0
        val celsiusFromRecurring = TemperatureConverter.toCelsius(anotherOriginalFahrenheit)
        val resultFahrenheitFromRecurring = TemperatureConverter.toFahrenheit(celsiusFromRecurring)
        resultFahrenheitFromRecurring shouldBe (anotherOriginalFahrenheit plusOrMinus tolerance)
    }
})