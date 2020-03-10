package com.example.kotlininaction

import android.view.View

fun main() {

//    objectExpressionVsLambda()

    val listener = View.OnClickListener { view ->
        val text = when(view.id){
            1 -> "First button clicked"
            2 -> "Second button clicked"
            else -> "Unknown button"
        }
        showToast(text)
    }
//    button1.setOnClickListener(listener)
//    button2.setOnClickListener(listener)

    //Note:
    //listeners cannot be unsubscribed when they are declared this way since a lambda is only a
    //block of code to the compiler, not an object
}

fun showToast(text: String) {
    println(text)
}

private fun objectExpressionVsLambda() {
    //difference:
    //If the lambda does not access any variables from the function where it is defined,
    //the corresponding anonymous class instance is reused between calls.
    //With an object expression, every time it is called, a new object is created

    //compiler automatically converts the function into an instance of an anonymous class implementing Runnable
    SAMinterfaceJava().postponeComputation(100) { println(42) }

    //Pass an object expression as an implementation of a functional interface
    SAMinterfaceJava().postponeComputation(100, object : Runnable {
        override fun run() {
            println(42)
        }
    })
}