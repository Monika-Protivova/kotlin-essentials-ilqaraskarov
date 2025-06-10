package com.motycka.edu.lesson02


val coffeeOrders = mutableMapOf<Int, List<String>>()
val coffeePrices = mapOf(
    "Espresso" to 2.5,
    "Double Espresso" to 3.0,
    "Cappuccino" to 3.0,
    "Latte" to 3.5,
    "Americano" to 2.0,
    "Flat White" to 3.2
)
var nextId:Int = 1
fun main() {
    // You can write code here to try the functions
    processOrder(listOf(ESPRESSO, CAPPUCCINO, CAPPUCCINO, AMERICANO), 20.0)
    processOrder(listOf(ESPRESSO, FLAT_WHITE, AMERICANO), 10.0)
    // processOrder(listOf(ESPRESSO, ESPRESSO, DOUBLE_ESPRESSO), 5.0) // will fail due to insufficient payment
}

/* Implement the functions below */

fun processOrder(items: List<String>, payment: Double): Double {
    val orderId = placerOrder(items)
    val totalToPay = payOrder(orderId)

    val change  = payment - totalToPay
    // TODO call completeOrder(orderId)
    completeOrder(orderId)
    println("Payment successful. Total paid: $payment, Total to pay: $totalToPay, change: $change")
    return change
}

// TODO Implement placerOrder(items: List<String>): Int
fun placerOrder(items: List<String>):Int{
    coffeeOrders[nextId] = items
    return nextId++
}
// TODO Implement payOrder(orderId: Int): Double
fun payOrder(orderId:Int): Double{
    val order = coffeeOrders[orderId] ?: throw IllegalArgumentException("Order ID $orderId not found.")
    val prices = order.map { item -> coffeePrices[item] ?: 0.0 }
    return prices.sum()
}

// TODO Implement completeOrder(orderId: Int)
fun completeOrder(orderId: Int){
    coffeeOrders.remove(orderId)
}

