package com.motycka.edu.lesson03.model

import kotlin.math.PI // PI is used by Circle

// Ensure Sphere class is defined (e.g., in Sphere.kt) if Circle.to3D() creates it.
// Or ensure Shape3D is defined if it returns a generic Shape3D that will be a Sphere.

import kotlin.math.PI

class Circle(override val radius: Double) : Shape2D, Ellipse {

    init {
        if (radius < 0) {
            throw IllegalArgumentException("Circle radius cannot be negative.")
        }
    }

    override fun area(): Double {
        // Test: Math.PI * 25.0 for radius 5.0
        return PI * radius * radius
    }

    override fun perimeter(): Double {
        // Test: 2 * Math.PI * 5.0 for radius 5.0
        return 2 * PI * radius
    }

    override fun to3D(): Shape3D {
        // Test expects a Sphere
        return Sphere(this.radius)
    }
}
