package com.example.kotlininaction

fun main() {
    val someString = "12.123-6.A"
    //Regular expression
    println(someString.split("\\.|-".toRegex()))
    //Strings
    println(someString.split(".", "-"))
    //Characters
    println(someString.split('.', '-'))

    val path = "/Users/MyDirectory/chapter.docx"
    parsePath(path)
}

fun parsePath(path: String) {
    val directory = path.substringBeforeLast('/')
    val fullname = path.substringAfterLast('/')
    val filename = fullname.substringBefore('.')
    val fileExtension = fullname.substringAfter('.')
    println("Dir: $directory, Filename: $filename, File Extension: $fileExtension ")
}