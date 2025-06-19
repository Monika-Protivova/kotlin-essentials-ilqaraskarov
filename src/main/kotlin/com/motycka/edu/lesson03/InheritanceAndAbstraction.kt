package com.motycka.edu.lesson03

import com.motycka.edu.lesson03.model.*
import kotlin.math.PI
import kotlin.math.pow // For Sphere calculations, if needed.

fun main() {
    println("--- Rectangle ---")
    val rectangle = Rectangle(2.0, 3.0)
    println("Rectangle area: ${"%.2f".format(rectangle.area())}")
    println("Rectangle perimeter: ${"%.2f".format(rectangle.perimeter())}")

    println("\n--- Square ---")
    val square = Square(5.0)
    println("Square area: ${"%.2f".format(square.area())}")
    println("Square perimeter: ${"%.2f".format(square.perimeter())}")
    println("Square width (inherited): ${square.width}") // Should be 5.0

    println("\n--- Cube (from Square.to3D) ---")
    // square.to3D(square.width) uses the inherited (or overridden) to3D method from Quadrilateral
    // where depth is set to square's side, creating a Cuboid(side, side, side).
    val cube = square.to3D(square.width)
    println("Cube volume: ${"%.2f".format(cube.volume())}")
    println("Cube surface area: ${"%.2f".format(cube.surfaceArea())}")
    if (cube is Cuboid) {
        println("Cube (as Cuboid) dimensions: w=${cube.width}, h=${cube.height}, d=${cube.depth}") // UPDATED
    }

    println("\n--- Cuboid (from Rectangle.to3D) ---")
    val cuboid = rectangle.to3D(4.0)
    println("Cuboid volume: ${"%.2f".format(cuboid.volume())}")
    println("Cuboid surface area: ${"%.2f".format(cuboid.surfaceArea())}")
    if (cuboid is Cuboid) {
        println("Cuboid dimensions: w=${cuboid.width}, h=${cuboid.height}, d=${cuboid.depth}") // UPDATED
    }

    println("\n--- Circle ---")
    val circle = Circle(4.0)
    println("Circle area: ${"%.2f".format(circle.area())}")
    println("Circle perimeter: ${"%.2f".format(circle.perimeter())}")

    println("\n--- Sphere (from Circle.to3D) ---")
    val sphere = circle.to3D()
    println("Sphere volume: ${"%.2f".format(sphere.volume())}")
    println("Sphere surface area: ${"%.2f".format(sphere.surfaceArea())}")
    if (sphere is Sphere) {
        println("Sphere radius: ${sphere.radius}")
    }

    // Test invalid inputs
    try {
        println("\n--- Testing Invalid Inputs ---")
        Rectangle(-1.0, 1.0)
    } catch (e: IllegalArgumentException) {
        println("Caught expected: ${e.message}")
    }
    try {
        Square(-2.0)
    } catch (e: IllegalArgumentException) {
        println("Caught expected: ${e.message}")
    }
    try {
        rectangle.to3D(-1.0)
    } catch (e: IllegalArgumentException) {
        println("Caught expected: ${e.message}")
    }
    try {
        Circle(-3.0)
    } catch (e: IllegalArgumentException) {
        println("Caught expected: ${e.message}")
    }
}