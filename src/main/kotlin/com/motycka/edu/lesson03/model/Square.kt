package com.motycka.edu.lesson03.model

// Assumes Rectangle and Cuboid classes are available

class Square(val side: Double) : Rectangle(side, side) {

    init {
        // Validation is handled by Rectangle's init block.
        // If Square needs its own message: if (side < 0) throw IllegalArgumentException("Square side cannot be negative.")
    }

    // Override area for clarity, though super.area() would work.
    override fun area(): Double {
        return side * side
    }

    // Override perimeter for clarity.
    override fun perimeter(): Double {
        return 4 * side
    }

    // The test `square.callMethod("to3D")` (no arguments) requires this method.
    // It should create a cube.
    fun to3D(): Shape3D {
        // For Square(5.0), expects Cuboid with width=5, height=5, depth=5
        return Cuboid(side, side, side)
    }
}