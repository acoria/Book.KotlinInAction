package com.example.kotlininaction

fun main(){
    println("Hello World!")
    println(printNumbersAsString(1,2))
    println(maxWithBlockBody(1,3))
    println(maxWithExpressionBody(1,4))
    println(maxWithExpressionBodyEvenShorter(2,1))
    println(stringTemplates("Jimmy"))
    playingWithStrings(2)
}

fun printNumbersAsString(a: Int, b: Int): String{
    return a.toString() + b.toString()
}

//block body
fun maxWithBlockBody(a: Int, b: Int): Int{
    return if(a > b) a else b
}

//expression body
fun maxWithExpressionBody(a: Int, b: Int): Int = if(a > b) a else b

//type inference = compiler guesses the type
fun maxWithExpressionBodyEvenShorter(a: Int, b: Int) = if(a > b) a else b

fun stringTemplates(name: String): String {
    val name = if (name.length > 0) name else "No name"
    return "Hello, $name!"
}

fun variables(){
    val answer: Int
    answer = 42

    var number: Int
    number = 34
    number = 75
}

fun initializeVal(no: Int){
    val number: Int
    if(no > 3){
        number = 10
    }else{
        number = 11
    }
}

fun playingWithStrings(count: Int){
    val number = 42
    println("Say $number!")
    println("Say ${number}hello")
    println("hm.. ${stringTemplates("my Name")}")
    println("Say ${if(count > 10) "hi" else "ho"}")
    println("\$ escaped dollar sign")
}