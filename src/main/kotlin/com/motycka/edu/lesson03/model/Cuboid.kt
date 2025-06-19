package com.motycka.edu.lesson03.model

class Cuboid(
    val width: Double,   // Property name must match test's getPropertyValue("width")
    val height: Double,  // Property name must match test's getPropertyValue("height")
    val depth: Double    // Property name must match test's getPropertyValue("depth")
) : Shape3D {

    init {
        if (width < 0 || height < 0 || depth < 0) {
            throw IllegalArgumentException("Cuboid dimensions (width, height, depth) cannot be negative.")
        }
    }

    override fun volume(): Double {
        return width * height * depth
    }

    override fun surfaceArea(): Double {
        return 2 * ((width * height) + (width * depth) + (height * depth))
    }
}