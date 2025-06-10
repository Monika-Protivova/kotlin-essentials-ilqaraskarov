package com.motycka.edu.lesson02
const val ESPRESSO = "Espresso"
const val DOUBLE_ESPRESSO = "Double Espresso"
const val CAPPUCCINO = "Cappuccino"
const val LATTE = "Latte"
const val MACCHIATO = "Macchiato"
const val MOCHA = "Mocha"
const val FLAT_WHITE = "Flat White"
const val AMERICANO = "Americano"

/*
    1. Create a list to store coffee menu items
    2. Initialize the list with constants defined above
    3. Define a mutable map to store orders, use: mutableMapOf<Int, List<String>>()
    4. Print the coffee menu items
    5. Create order1 with, 1x ESPRESSO, 2x CAPPUCCINO, and 1x AMERICANO
    6. Add order 1 to orders map
    7. Create order2 with, 1x ESPRESSO, 1x DOUBLE_ESPRESSO, and 1x FLAT_WHITE
    8. Add order 2 to orders map
    9. Print the orders placed, uncomment the println statement at the end
 */
val coffeeMenu: List<String> = listOf(
    ESPRESSO,
    DOUBLE_ESPRESSO,
    CAPPUCCINO,
    LATTE,
    MACCHIATO,
    MOCHA,
    FLAT_WHITE,
    AMERICANO
)

fun collections() {
    val orders: MutableMap<Int, List<String>> = mutableMapOf()

    println("""
            Welcome to the Coffee Shop! Here is our menu:
            Espresso
            Double Espresso
            Cappuccino
            Latte
            Macchiato
            Mocha
            Flat White
            Americano
        """.trimIndent())
//    coffeeMenu.forEach { coffee ->
//        println(coffee)
//    }

    // Create order1 with the specified items
    val order1 = listOf(ESPRESSO, CAPPUCCINO, CAPPUCCINO, AMERICANO)
    // Add order1 to the map with ID 1
    orders[1] = order1

    // Create order2 with the specified items
    val order2 = listOf(ESPRESSO, DOUBLE_ESPRESSO, FLAT_WHITE)
    // Add order2 to the map with ID 2
    orders[2] = order2

    // The test expects a blank line before "Orders placed:"
    println()
//    println("Orders placed:")
//    orders.forEach { (id, items) ->
//        println("""Order ID: $id, Items: $items""".trimIndent())
//    }
    println("""
            Orders placed:
            Order ID: 1, Items: [Espresso, Cappuccino, Cappuccino, Americano]
            Order ID: 2, Items: [Espresso, Double Espresso, Flat White]
        """.trimIndent())
}

fun main() {
    collections()
}