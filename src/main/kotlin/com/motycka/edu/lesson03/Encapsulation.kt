package com.motycka.edu.lesson03

import java.time.LocalDate

/*
  TODO implement the Assignment class.

  The class should have the following public properties:
    - `dueDate` of type `LocalDate` - should be public, immutable and initialized in the constructor
    - `assignee` of type `String` - should be public, immutable and initialized in the constructor

  And the following private property:
    - `finalGrade` of type `Int?` (nullable) - should be private, mutable and initialized to null

  And the following methods:
    - `setFinalGrade(grade: Int)`: sets the finalGrade for the assignment, but only if it is between 0 and 100 (inclusive).
      Use: require(finalGrade in 0..100) { "Final grade must be between 0 and 100" }
    - `getFinalGrade()`: returns the finalGrade for the assignment.
 */

class Assignment(
    val dueDate: LocalDate,
    val assignee: String
) {
    private var finalGrade: Int? = null

    fun setFinalGrade(grade: Int) {
        require(grade in 0..100) { "Final grade must be between 0 and 100" }
        this.finalGrade = grade
    }

    fun getFinalGrade(): Int? {
        return this.finalGrade
    }
}

/*
 Uncomment the main function to try the solution.
 */

fun main() {
    val assignment = Assignment(LocalDate.now().plusDays(7), "John Doe")
    println("Assignment for ${assignment.assignee} due on ${assignment.dueDate}")
    println("Initial grade: ${assignment.getFinalGrade()}") // Should be null

    try {
        assignment.setFinalGrade(90)
        println("Grade after setting to 90: ${assignment.getFinalGrade()}") // Should be 90
    } catch (e: IllegalArgumentException) {
        println("Error setting grade: ${e.message}")
    }

    try {
        assignment.setFinalGrade(105) // This should throw an exception
        println("Grade after attempting to set to 105: ${assignment.getFinalGrade()}")
    } catch (e: IllegalArgumentException) {
        println("Error setting grade to 105: ${e.message}") // Expected output
    }

    println("Current grade: ${assignment.getFinalGrade()}") // Should still be 90

    try {
        assignment.setFinalGrade(-5) // This should also throw an exception
        println("Grade after attempting to set to -5: ${assignment.getFinalGrade()}")
    } catch (e: IllegalArgumentException) {
        println("Error setting grade to -5: ${e.message}") // Expected output
    }
    println("Final grade after all attempts: ${assignment.getFinalGrade()}") // Should still be 90

    // Test setting another valid grade
    assignment.setFinalGrade(75)
    println("Grade after setting to 75: ${assignment.getFinalGrade()}") // Should be 75
}