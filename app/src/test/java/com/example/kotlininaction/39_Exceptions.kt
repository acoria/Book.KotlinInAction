package com.example.kotlininaction

import java.io.BufferedReader
import java.io.StringReader
import java.lang.NumberFormatException


fun readNumber(reader: BufferedReader){
    val number = try {
        val theReadNumber = Integer.parseInt(reader.readLine())
        //the last line is always the return value
        theReadNumber //unnecessary->just testing
        //instead you could write
//        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException){
        null
    }
    println(number)
}

fun main() {
    val reader = BufferedReader(StringReader("3"))
//    val reader = BufferedReader(StringReader("Not a number"))
    readNumber(reader)
    reader.close()
    println("Test finished")
}