package com.example.kotlininaction

import strings.lastChar
import strings.secondLastChar

fun main() {
    println("Kotlin".lastChar())

    val sb = StringBuilder("Kotlin?")
    sb.secondLastChar = 'N'
    println(sb)
}