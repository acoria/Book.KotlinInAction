package com.example.kotlininaction

fun calculate(numberToTheLeft: Int, numberToTheRight: Int, calculation: (numberLeft: Int, numberRight: Int) -> Int){
    println(calculation(numberToTheLeft, numberToTheRight))
}

val sum = {x: Int, y: Int -> x + y}
val subtract = {x: Int, y: Int -> x - y }
val divide = { x: Int, y: Int -> x / y }
val multiply = {x: Int, y: Int -> x * y}

fun main() {
    calculate(4,5, sum)
    calculate(10, 2, subtract)
    calculate(30, 3, divide)
    calculate(50, 2, multiply)

    calculate(3, 4) { x: Int, y: Int -> x+y+x}
}