package com.motycka.edu.lesson03

import kotlin.math.PI

/*
 Implement an object called AreaCalculator with the following methods:
 - fun calculateRectangleArea(a: Double, b: Double): Double
 - fun calculateRectangleArea(a: Int, b: Int): Double
 - fun calculateCircleArea(r: Double): Double
 - fun calculateCircleArea(r: Int): Double
 - fun calculateTriangleArea(a: Double, b: Double): Double  // Assuming a = base, b = height
 - fun calculateTriangleArea(a: Int, b: Int): Double    // Assuming a = base, b = height

 The class demonstrates static polymorphism by providing multiple methods with the same name but different parameter types (Int and Double).
 The check will tolerate 0.001 inaccuracy.
 */
object AreaCalculator {

    /**
     * Calculates the area of a rectangle.
     * @param a The length of one side of the rectangle.
     * @param b The length of the adjacent side of the rectangle.
     * @return The area of the rectangle as a Double.
     */
    fun calculateRectangleArea(a: Double, b: Double): Double {
        require(a >= 0 && b >= 0) { "Rectangle dimensions must be non-negative." }
        return a * b
    }

    /**
     * Calculates the area of a rectangle.
     * @param a The length of one side of the rectangle (integer).
     * @param b The length of the adjacent side of the rectangle (integer).
     * @return The area of the rectangle as a Double.
     */
    fun calculateRectangleArea(a: Int, b: Int): Double {
        require(a >= 0 && b >= 0) { "Rectangle dimensions must be non-negative." }
        return calculateRectangleArea(a.toDouble(), b.toDouble())
    }

    /**
     * Calculates the area of a circle.
     * @param r The radius of the circle.
     * @return The area of the circle as a Double.
     */
    fun calculateCircleArea(r: Double): Double {
        require(r >= 0) { "Circle radius must be non-negative." }
        return PI * r * r
    }

    /**
     * Calculates the area of a circle.
     * @param r The radius of the circle (integer).
     * @return The area of the circle as a Double.
     */
    fun calculateCircleArea(r: Int): Double {
        require(r >= 0) { "Circle radius must be non-negative." }
        return calculateCircleArea(r.toDouble())
    }

    /**
     * Calculates the area of a triangle, assuming 'a' is the base and 'b' is the height.
     * Formula: 0.5 * base * height
     * @param a The base of the triangle.
     * @param b The height of the triangle.
     * @return The area of the triangle as a Double.
     */
    fun calculateTriangleArea(a: Double, b: Double): Double {
        require(a >= 0 && b >= 0) { "Triangle dimensions (base and height) must be non-negative." }
        return 0.5 * a * b
    }

    /**
     * Calculates the area of a triangle, assuming 'a' is the base and 'b' is the height.
     * Formula: 0.5 * base * height
     * @param a The base of the triangle (integer).
     * @param b The height of the triangle (integer).
     * @return The area of the triangle as a Double.
     */
    fun calculateTriangleArea(a: Int, b: Int): Double {
        require(a >= 0 && b >= 0) { "Triangle dimensions (base and height) must be non-negative." }
        return calculateTriangleArea(a.toDouble(), b.toDouble())
    }
}

/*
 Uncomment the main function to try the solution.
 */

fun main() {
    println("--- Rectangle Area ---")
    println("Rectangle (5.0, 10.0): ${AreaCalculator.calculateRectangleArea(5.0, 10.0)}") // Expected: 50.0
    println("Rectangle (5, 10): ${AreaCalculator.calculateRectangleArea(5, 10)}")     // Expected: 50.0
    println("Rectangle (3.5, 2.0): ${AreaCalculator.calculateRectangleArea(3.5, 2.0)}") // Expected: 7.0

    println("\n--- Circle Area ---")
    println("Circle (r=7.0): ${AreaCalculator.calculateCircleArea(7.0)}")         // Expected: ~153.938
    println("Circle (r=7): ${AreaCalculator.calculateCircleArea(7)}")             // Expected: ~153.938
    println("Circle (r=1.0): ${AreaCalculator.calculateCircleArea(1.0)}")         // Expected: ~3.14159

    println("\n--- Triangle Area (assuming base and height) ---")
    println("Triangle (base=6.0, height=4.0): ${AreaCalculator.calculateTriangleArea(6.0, 4.0)}") // Expected: 12.0
    println("Triangle (base=6, height=4): ${AreaCalculator.calculateTriangleArea(6, 4)}")         // Expected: 12.0
    println("Triangle (base=5.0, height=3.0): ${AreaCalculator.calculateTriangleArea(5.0, 3.0)}") // Expected: 7.5

    // Test with zero values
    println("\n--- Zero Value Tests ---")
    println("Rectangle (0, 10): ${AreaCalculator.calculateRectangleArea(0, 10)}")     // Expected: 0.0
    println("Circle (r=0): ${AreaCalculator.calculateCircleArea(0)}")             // Expected: 0.0
    println("Triangle (base=0, height=4): ${AreaCalculator.calculateTriangleArea(0, 4)}") // Expected: 0.0

    // Test for negative values (should throw IllegalArgumentException)
    println("\n--- Negative Value Tests (expecting errors) ---")
    try {
        AreaCalculator.calculateRectangleArea(-5, 10)
    } catch (e: IllegalArgumentException) {
        println("Caught expected error for rectangle: ${e.message}")
    }
    try {
        AreaCalculator.calculateCircleArea(-2.0)
    } catch (e: IllegalArgumentException) {
        println("Caught expected error for circle: ${e.message}")
    }
    try {
        AreaCalculator.calculateTriangleArea(5, -2)
    } catch (e: IllegalArgumentException) {
        println("Caught expected error for triangle: ${e.message}")
    }
}