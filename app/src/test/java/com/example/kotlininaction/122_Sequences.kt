package com.example.kotlininaction

import kotlin.system.measureTimeMillis

//Operations on sequences (unlike collections) are lazily executed for individually for each
//element. An operation on a collection creates a copy of the entire transformed list.
//Sequences allow you to stop executing followup operations on elements when values do not meet
//a certain criteria (e.g. filter) or a value is found (find-function)

fun main() {

    val listOfAMillionEntries = ((1..1000000).toList())

//    repeat(5) {
//        println("${measureTimeMillis { mapWithCopiedLists(listOfAMillionEntries) }} <- copied")
//    }
//    repeat(5) {
//        println("${measureTimeMillis { mapWithSequence(listOfAMillionEntries) }} <- sequenced")
//    }
    generateOwnSequence()
}

fun generateOwnSequence() {
    val naturalNumbers = generateSequence(0) { it + 1 }
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    //terminal operation -> sum
    println(numbersTo100.sum())
}

private fun mapWithCopiedLists(listOfAMillionEntries: List<Int>) {
    listOfAMillionEntries
        .map { it + 1 }
        .map { it.toString() }
}

private fun mapWithSequence(listOfAMillionEntries: List<Int>){
    listOfAMillionEntries.asSequence()
        .map{ it + 1 }
        .map{ it.toString() }.toList()
}