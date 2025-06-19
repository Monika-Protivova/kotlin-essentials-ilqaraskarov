package com.motycka.edu.lesson03.model

import kotlin.math.PI
import kotlin.math.pow

import kotlin.math.PI
import kotlin.math.pow

class Sphere(val radius: Double) : Shape3D {

    init {
        if (radius < 0) {
            throw IllegalArgumentException("Sphere radius cannot be negative.")
        }
    }

    override fun volume(): Double {
        // Test: (4.0/3.0) * Math.PI * 27.0 for radius 3.0
        return (4.0 / 3.0) * PI * radius.pow(3)
    }

    override fun surfaceArea(): Double {
        // Test: 4 * Math.PI * 9.0 for radius 3.0
        return 4 * PI * radius.pow(2)
    }
}