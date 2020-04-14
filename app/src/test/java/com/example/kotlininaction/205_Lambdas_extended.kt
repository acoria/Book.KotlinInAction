package com.example.kotlininaction

import java.lang.StringBuilder

//starting point: self-implemented extension function for joinToString
fun <T> Collection<T>.joinToString(
    separator: String = ","
): String{
    val result = StringBuilder()


    for((index, element) in this.withIndex()) {
        if (index > 0) {
            result.append(separator)
        }
        //converts the object to a string using the default toString method
        result.append(element)
    }

    return result.toString()
}

//specifying a default value for a function type
fun <T> Collection<T>.joinToStringUsingTransformParam(
    separator: String = ",",
    transform: (T) -> String = { it.toString() }
): String{
    val result = StringBuilder()


    for((index, element) in this.withIndex()) {
        if (index > 0) {
            result.append(separator)
        }
        //converts the object to a string using the default toString method
        result.append(transform(element))
    }

    return result.toString()
}

fun main() {
    val listOfNames = listOf<String>("Jack", "Jane")

    println(listOfNames.joinToString("-"))
    println(listOfNames.joinToStringUsingTransformParam("+"))
    println(listOfNames.joinToStringUsingTransformParam("+") { it.toUpperCase() })

}