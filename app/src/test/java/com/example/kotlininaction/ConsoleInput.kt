package com.example.kotlininaction

fun main() {
 askToLeave()
}

fun askToLeave() {
    do {
        print("Leave the program (y/n): ")
    } while (readLine() != "y")
}