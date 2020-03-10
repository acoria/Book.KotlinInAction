package com.example.kotlininaction

import android.widget.TextView
import java.lang.StringBuilder
import android.content.Context


fun alphabet(): String {
    val result = StringBuilder()
    for(letter in 'A'..'Z'){
        result.append(letter)
    }
    result.append("\nNow I know the alphabet")
    return result.toString()
}

//the with function converts its first argument into a receiver of the lambda that is passed
//as the second argument. The receiver can be accessed via "this"
fun alphabetUsingWith(): String {
    val stringBuilder = StringBuilder()
    return with(stringBuilder) {
        for (letter in 'A'..'Z'){
            //use "this"
            this.append(letter)
        }
        //omit "this"
        append("\nNow I know the alphabet using with")
        this.toString()
    }
}

fun alphabetWithExpressionBodySyntax() = with(StringBuilder()) {
    for (letter in 'A'..'Z'){
        append(letter)
    }
    append("\nNow I know the alphabet as expression body")
    toString()
}

class ClassWithToString{
    override fun toString(): String{
        return "String from the outer class"
    }
    fun callAnAlphabetFun():String{
        return with(StringBuilder()) {
            for(letter in 'A'..'Z'){
                append(letter)
            }
            this@ClassWithToString.toString()
        }
    }
}

fun alphabetWithApply() = StringBuilder().apply {
    for(letter in 'A'..'Z'){
        append(letter)
    }
    append("\nNow I know the alphabet with apply")
}

//create a text view and pass it immediately to apply function (becomes the receiver)
fun createViewWithCustomAttributes(context: Context): TextView{
    return TextView(context).apply {
        text = "Some text"
        textSize = 10.0f
        setPadding(10,0,0,0)
    }
}

fun alphabetWithBuildInStringBuilder() = buildString {
    for(letter in 'A'..'Z'){
        append(letter)
    }
    append("\nWith build in String builder")
}

fun main() {
    println(alphabet())
    println(alphabetUsingWith())
    println(alphabetWithExpressionBodySyntax())
    println(ClassWithToString().callAnAlphabetFun())
    println(alphabetWithApply().toString())
    println(alphabetWithBuildInStringBuilder())
}