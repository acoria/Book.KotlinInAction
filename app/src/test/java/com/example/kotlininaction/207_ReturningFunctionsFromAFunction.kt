package com.example.kotlininaction

enum class Delivery { STANDARD, EXPEDITED }
class Order(val itemCount: Int)

fun getShippingCostCalculator(delivery: Delivery): (Order) -> Double {

    val standardCalculator = { order: Order -> 1.2 * order.itemCount }

    if(delivery == Delivery.EXPEDITED){
        return { order -> 6 + 2.1 * order.itemCount }
    }
    return standardCalculator

}

fun main() {
    val calculator = getShippingCostCalculator(Delivery.STANDARD)
    println(calculator(Order(2)))
}