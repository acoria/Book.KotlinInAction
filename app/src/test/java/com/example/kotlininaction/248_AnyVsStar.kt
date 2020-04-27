package com.example.kotlininaction

import kotlin.random.Random


//MutableList<*> vs. MutableList<Any?>
//MutableList<Any?> is a list that can contain elements of any type
//MutableList<*> is a list that contains elements of a specific type but you don't know
//what type it is

val list: MutableList<Any?> = mutableListOf('a', 1, "abc")
val chars = mutableListOf('a', 'b', 'c')
val unknownElements: MutableList<*> = if(Random.nextBoolean()) list else chars

fun main() {
    unknownElements.first()

    //Does not compile. In this example MutableList<*> is projected (acts as) MutableList<out Any?>.
    //When you know nothing about the type of the element, it is safe to get elements of Any? type
    //but it is not safe to put elements into the list.
//    unknownElements.add(42)
}

//You can use the star-projection syntax when the information about type arguments isn't important:
//You cont'use any methods that refer to the type parameter in the signature, or you only read the
//data and you don't care about its specific type. E.g. a printFirst method that excepts any list:
fun printFirst(list: List<*>){
    //isNotEmpty doesn't use the generic type
    if(list.isNotEmpty()) {
        //first returns Any?
        println(list.first())
    }
}

//if you are interested in the type parameter, use generics
fun <T> printFirstGeneric(list: List<T>){
    //first returns a value of T
    println(list.first())
}
