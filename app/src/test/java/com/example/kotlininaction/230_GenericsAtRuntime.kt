package com.example.kotlininaction

import java.lang.IllegalArgumentException

//generics are erased at runtime. This means an instance of a generic class doesn't carry
//information about the type arguments used to create that instance
//e.g. definition: List<T> --> created as List<Int>
//at runtime, you can find out if it is a list but not its type "Int"


class PlayingWithGenericList<T>(private val element: T){

    fun createAListOfTypeInt() : List<Int>{
        return listOf(1,2)
    }

    fun createAListWithGenericType() : List<T>{
        return listOf(element, element)
    }
}

fun main() {
//    integerList()
//    genericList()

    //as expected
//    printSum(listOf(1,2,3))

    //not a list -> IllegalArgumentException expeced
//    printSum(setOf(1,2,3))

    //ClassCastException is thrown, when strings are tried to be added up
    //That the list is not of type "Int" could not be checked
    printSum(listOf("one", "two", "three"))
}

//Generic types are deleted at runtime
fun genericList() {
    val genericList = PlayingWithGenericList("a string").createAListWithGenericType()

    //this checks if the generic list is a list but the type is unknown
    //it could be a list of type Int
    if(genericList is List<String>){
        println("Generic list")
    }

    if(genericList is List<*>){
        println("Generic list but the type was erased")
    }

    //List type cannot be checked because type gets erased at runtime
//    if(genericList is List<Int>){
        //does not compile
//    }
}

private fun integerList() {
    var totalNumber = 0
    val listOfInt = PlayingWithGenericList(1).createAListOfTypeInt()
    if (listOfInt is List<Int>) {
        for (number in listOfInt) {
            totalNumber += number
        }
    }
    println(totalNumber)
}

private fun printSum(collection: Collection<*>){
    //warning about unchecked cast -> is ok because it is handled by the exception
    //this check is only to determine if the collection is a list, not for the type Int
    val intList = collection as? List<Int> ?: throw IllegalArgumentException("List is expected")
    println(intList.sum())
}