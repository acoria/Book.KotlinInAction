package com.example.kotlininaction

//Reified ("=remember") declares that the type parameter is not erased at runtime.
//This only works for inline functions because the coding is copied directly with the
//type into the specific place and therefore is not deleted.

//does not compile
//fun <T> isA(value: Any) = value is T

//as inlined function and the parameter as reified compiles
inline fun <reified T> isA(value: Any) = value is T

fun main() {
    println(isA<String>("someString"))
    println(isA<String>(1))
}
