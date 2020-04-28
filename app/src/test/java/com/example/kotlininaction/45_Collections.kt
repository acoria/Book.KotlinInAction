package com.example.kotlininaction

import strings.joinToStringTopLevel
//@JvmOverloads: Generates overload methods for Kotlin methods with default parameters in Java
//for every parameter starting with the last

class CollectionsInKotlin {
    @JvmOverloads
    fun <T> joinToString(
        collection: Collection<T>,
        separator: String,
        prefix: String = "(",
        postfix: String = ")"
    ): String{
        val result = StringBuilder(prefix)
        for((index, element) in collection.withIndex()){
            //dont append a separator before the first element
            if (index > 0) result.append(separator)
            result.append(element)
        }
        result.append(postfix)
        return result.toString()
    }
}

fun main() {
//    getStarted()
//    playingWithExtensionFunctions()
    println(passArbitraryNumberOfArguments("a","b","c","d"))
}


fun passArbitraryNumberOfArguments(vararg params: String): List<String>{
    //* => spread operator, lets you unpack the array
    return listOf("params: ", *params)
}

private fun playingWithExtensionFunctions() {
    val list = listOf(1, 2, 3)
    println(list)
    println(CollectionsInKotlin().joinToString(list, separator = "; ", prefix = "(", postfix = ")"))
    println(CollectionsInKotlin().joinToString(list, prefix = "#", separator = "; "))

    joinToStringTopLevel(list)
}


private fun getStarted() {
    //a set has unique values (unlike list)
    val hashSet = hashSetOf(1, 53, 53)
    val arrayList = arrayListOf(1, 7, 53)
    val list = listOf(1, 7, 53, 7)
    val hashMap = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three", 7 to "seven")
    val map = mapOf(1 to "one", 7 to "seven", 53 to "fifty-three", 7 to "seven")


    val listOfNumbers = listOf("first", "second", "third")

    println("Hashed Set $hashSet")
    println("ArrayList $arrayList")
    println("List $list")
    println("Hashed Map $hashMap")
    println("Map $map")
    println(listOfNumbers.last())

    val listWithNumers = listOf(1, 45, 5)
    println("biggest number in list: ${listWithNumers.max()}")
    val setWithNumbers = setOf(1, 45, 5)
    println("biggest number in set ${setWithNumbers.max()}")
}