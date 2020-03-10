package com.example.kotlininaction

internal open class Cake{
    private fun slice(){}
}

//does not compile without internal-keyword
internal fun Cake.eat(){

}
