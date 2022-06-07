package com.example.kotlininaction

//Infix calls can be used with regular methods and extension functions that have one required
//parameter

fun main() {

    val mapWithInfix = mapOf(1 to "one", 2 to "two")
    println(mapWithInfix)

    val mapWithoutInfix = mapOf(1.to("one"), 2.to("two"))
    println(mapWithoutInfix)

    val mapForMyOwnInfixFun = mapOf("someString" addMyOwnPair "theMappedString")
    println(mapForMyOwnInfixFun)

    println(Pair(1,"one"))
    println(1 makeMagicHappen "one")

    val (number, name) = 1 to "one"
    println("number: $number, name: $name")

    val list = listOf("one","two","three")
    for((index, value) in list.withIndex()){
        println("$index, $value")
    }

    val someString = "some String to " concat "with another String"
    println(someString)

}

infix fun String.addMyOwnPair(myValue: String) = Pair(this, myValue)

infix fun Int.makeMagicHappen(stringToAdd: String) = Pair(this, stringToAdd)

infix fun String.concat(newValue: String): String = this + newValue