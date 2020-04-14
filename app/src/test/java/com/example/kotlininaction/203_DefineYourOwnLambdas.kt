package com.example.kotlininaction

fun String.filterCharacters(predicate: (Char) -> Boolean): String{
    val sb = StringBuilder()
    for(index in 0 until length){
        val element = get(index)
        if(predicate(element)) sb.append(element)
    }
    return sb.toString()
}

fun main() {
    println("ab1c".filterCharacters { it in 'a'..'z' })
}