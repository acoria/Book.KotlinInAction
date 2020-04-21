package com.example.kotlininaction

import java.lang.Appendable

//define an upper bound for a generic function

//e.g. a sum function can only sum up numbers, not strings -> so the upper bound is numbers
fun List<Int>.sumUpInts() : Int{
    var totalNumber = 0
    for(number in this){
        totalNumber += number
    }
    return totalNumber
}

fun <T : Number> List<T>.sumUpNumbers() : T{
    var totalNumber: T = this.first()
    for(number in this.drop(1)){
//        totalNumber += number
    }
    return totalNumber
}

fun <M: Comparable<M>>getMaxItem(first: M, second : M): M{
    return if(first.compareTo(second) > 0) first else second
    //shorter:
//    return if(first > second) first else second
}

//specifying more than one constraint
fun <T> ensureTrailingPeriod(seq: T)
    where T: CharSequence, T: Appendable{

    if(!seq.endsWith('.')){//endsWith -> extension function defined for CharSequence interface
        seq.append('.') //append is a method on the Append-interface
    }
}

fun main() {
    listOf(1,2,3).sumUpNumbers()
//    listOf('A'..'C').sumUpNumbers() -> not possible because of upper bound

    println(getMaxItem(1,2))
    println(getMaxItem("Kotlin", "Java"))

}