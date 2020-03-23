package com.example.kotlininaction

//Sealed classes: Resembles an enum -> contains data classes to ensure only certain types of
//subclasses can have a sealed superclass
//Simplifies when-statements because it is clear which types are to be expected

interface Expression

sealed class SealedExpressions: Expression {
    class Nummer(val value: Int): SealedExpressions()
    class Summe(val leftVal: Int, val rightVal: Int) : SealedExpressions()
}

fun eval(expr : SealedExpressions): Int{
    return when(expr){
        is SealedExpressions.Nummer -> expr.value
        is SealedExpressions.Summe -> expr.leftVal + expr.rightVal
    }
}

fun main() {
    println("${eval(SealedExpressions.Nummer(7))}")
    println("${eval(SealedExpressions.Summe(3, 8))}")
}