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
var nextId: Int = 1

fun main() {
    processOrder(listOf(ESPRESSO, CAPPUCCINO, CAPPUCCINO, AMERICANO), 20.0)
    processOrder(listOf(ESPRESSO, FLAT_WHITE, AMERICANO), 10.0)
}

fun processOrder(items: List<String>, payment: Double): Double {
    val orderId = placerOrder(items)
    val totalToPay = payOrder(orderId)

    if (payment < totalToPay) {
        throw IllegalStateException("Insufficient payment. Total to pay is $totalToPay, but received $payment.")
    }

    val change = payment - totalToPay
    completeOrder(orderId)
    println("Payment successful. Total paid: $payment, Total to pay: $totalToPay, change: $change")
    return change
}

fun placerOrder(items: List<String>): Int {
    coffeeOrders[nextId] = items
    return nextId++
}

fun payOrder(orderId: Int): Double {
    val order = coffeeOrders[orderId] ?: throw IllegalArgumentException("Order ID $orderId not found.")
    val prices = order.map { item -> coffeePrices[item] ?: 0.0 }
    val sum = prices.sum()
    return if (prices.size >= 3) sum - prices.minOrNull()!! else sum
}

fun completeOrder(orderId: Int) {
    if (!coffeeOrders.containsKey(orderId)) {
        throw IllegalStateException("Order ID $orderId not found.")
    }
    coffeeOrders.remove(orderId)
}