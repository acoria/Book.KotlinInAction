package com.example.kotlininaction

import kotlin.reflect.*
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.primaryConstructor

data class Northsea(val weather: String = "windy", val oceanHighTideTime: Int)

fun funToPrintNumber(numberToPrint: Int) = println(numberToPrint)

var topLevelProp = 5

fun main() {

    val northsea = Northsea(oceanHighTideTime = 1153)

    //get the Kotlin KClass<Northsea> class
    val kClass = northsea.javaClass.kotlin

    //access all properties of KClass
    println(kClass.simpleName)
    println("Members:")
    kClass.memberProperties.forEach { println(it.name) }

    val kFunction = ::funToPrintNumber
    //call a kFunction - option 1: "call"
    //(not type safe, will cause runtime error when called with wrong arguments)
    kFunction.call(76)
//    kFunction.call(76, 87) -> will cause runtime exception

    //call a kFunction - option 2: "invoke"
    kFunction.invoke(98)
//    kFunction.invoke(76, 78) -> does not compile

    //with "callBy", default parameters are filled with the default values, "call" does not do that
    val kFunctionPrimaryConstructor = kClass.primaryConstructor!!
    val paramMap = mapOf(kFunctionPrimaryConstructor.parameters.get(1) to 1200)
    val newNorthSea = kFunctionPrimaryConstructor.callBy(paramMap)
    println(newNorthSea)


    //kFunctions are function types that are synthetic compiler-generated types
    //you can pass any number of arguments

    //Example for 2 input and 1 output parameter
    fun sum(x: Int, y: Int) : Int = x + y
    val kFunction2: Function2<Int, Int, Int> = ::sum
    val summedUpNumber = kFunction2.invoke(3,4)
    println(summedUpNumber)

    //e.g. this is also possible
//    val kFunction15: Function15<>

    //access values of properties using "get(instanceOfclass)"
    kClass.memberProperties.forEach { println("prop name: ${it.name}, prop value: ${it.get(northsea)}") }

    //access a specific property using kProperty1
    //the first parameter defines the instance you have to pass, the second is the type of the
    //property
    val memberPropertyWeather : KProperty1<Northsea, String> = Northsea::weather
    val weatherValue = memberPropertyWeather.get(northsea)
    println(weatherValue)

    //for top-level property a kProperty0 (in this case even mutable since its a var) is returned
    val topLevelProperty : KMutableProperty0<Int> = ::topLevelProp
    //call the setter
    topLevelProperty.setter.call(77)
    println(topLevelProperty.get())
}
