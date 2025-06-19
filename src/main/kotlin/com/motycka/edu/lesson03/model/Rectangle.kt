package com.motycka.edu.lesson03.model

// Assumes Cuboid class implementing Shape3D is available

open class Rectangle(
    override val width: Double,
    override val length: Double
) : Shape2D, Quadrilateral {

    init {
        if (width < 0 || length < 0) {
            throw IllegalArgumentException("Rectangle dimensions (width, length) cannot be negative.")
        }
    }

    override fun area(): Double {
        // Test: 24.0 for Rectangle(4.0, 6.0)
        return width * length
    }

    override fun perimeter(): Double {
        // Test: 20.0 for Rectangle(4.0, 6.0)
        return 2 * (width + length)
    }

    override fun to3D(depth: Double): Shape3D {
        if (depth < 0) {
            throw IllegalArgumentException("Depth for 3D conversion cannot be negative.")
        }
        return Cuboid(this.width, this.length, depth) // Maps rect.width -> cuboid.width, rect.length -> cuboid.height
    }
}