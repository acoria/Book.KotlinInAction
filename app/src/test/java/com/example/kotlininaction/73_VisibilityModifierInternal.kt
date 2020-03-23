package com.example.kotlininaction

//Internal: new visibility modifier -> visible inside a module

internal open class Cake{
    private fun slice(){}
}

//does not compile without internal-keyword
internal fun Cake.eat(){

}
