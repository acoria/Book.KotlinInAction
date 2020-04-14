package com.example.kotlininaction

fun main() {

    //create a simple array
    println(arrayOf("a", "b", "c").joinToString())

    //initialize with null values
    println(arrayOfNulls<Int>(2).joinToString())

    //lambda initializes the values by passing in the index of the array
    val letters = Array(26) {index -> ('a' + index).toString()}
    println(letters.joinToString())

    //Always use collections over arrays. For Java code that asks for arrays, use toTypedArray

    val numberCollection = listOf(1,2,3)
    println(numberCollection.toTypedArray().joinToString())

}

class SomeOtherClass(val herName: String){
    val name: String

    init {
        name = herName + 1
    }

}