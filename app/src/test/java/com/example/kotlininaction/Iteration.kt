package com.example.kotlininaction

import java.util.*

fun doLoop(){

    var i = 10
    while(i>8){
        println("in while $i")
        i--
    }
    do{
       println("in do/while $i")
        i--
    }while (i>5)
}

fun fizzBuzz(i: Int) = when{
    i % 15 == 0 -> "FizzBuzz "
    i % 5 == 0 -> "Fizz"
    i % 3 == 0 -> "Buzz"
    else -> "$i "
}
fun playFizzBuzz(){
    for(i in 1..100 step 2){
        println(fizzBuzz(i))
    }
}
fun playFizzBuzzTheWrongWayRound(){
    for(i in 100 downTo 1){
        println(fizzBuzz(i))
    }
}
fun stepOverIt(){
    for(i in 1..10 step 2){
        println(i)
    }
}
fun maps(){
    val binaryReps = TreeMap<Char, String>()

    for(c in 'A'..'F'){
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }
    for((letter,binary) in binaryReps){
        println("$letter - $binary")
    }
}

fun mapIntegers(){
    val binaryReps = TreeMap<Int, String>()
    for(i in 1..10){
        binaryReps[i] = Integer.toBinaryString(i)
    }
    for((number, binary) in binaryReps){
        println("$number - $binary")
    }
}
fun iterateAnArray(){
    val list = arrayListOf("10", "11", "1001")
    for((index, value) in list.withIndex()){
        println("$index : $value")
    }
}
fun iterateListWithChars(){
    val list = 'A'..'F'
    for((index, value) in list.withIndex()){
        println("$index -> $value")
    }
}

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char) = c !in '1'..'9'

fun recognizeInput(inp: Char) = when(inp){
    in '0'..'9' -> "It is a digit"
    in 'a'..'z', in 'A'..'Z' -> "It is a letter"
    else -> "I have no clue"
}
fun testRangeOfStrings(){
    val zest = "Java".."Scala"
    val test = "Kotlin" in zest
    println(test)
}

fun main(){
//    doLoop()
//    playFizzBuzz()
//    playFizzBuzzTheWrongWayRound()
//    stepOverIt()
//    maps()
//    mapIntegers()
//    iterateAnArray()
//    iterateListWithChars()
//    println(isLetter('7'))
//    println(isNotDigit('v'))
//    println(recognizeInput('f'))
    testRangeOfStrings()
}