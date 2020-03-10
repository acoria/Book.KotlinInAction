package com.example.kotlininaction

interface Clickable{
    fun click()

    //default implementation (as long as it is stateless)
    fun showOff(){
        println("I am clickable!")
    }
}

interface Focusable{
    fun setFocus(b: Boolean){
        println("I ${if(b) "got" else "lost"} focus")
    }
    fun showOff(){
        println("I can also show off! Look at me!")
    }
}


class Button: Clickable{
    override fun click() {
        println("Button was clicked")
    }
}
class Switch: Clickable{
    override fun click(){
        println("Switch was clicked")
    }

    //default methods can be overwritten
    override fun showOff() {
        println("I do not like to show off")
    }
}

class ClassWithInterfacesWithTheSameMethodName: Clickable, Focusable{

    override fun click() {
        println("I, me.. was clicked")
    }

    override fun showOff() {
        super<Focusable>.showOff()
    }
}

fun main() {
    Button().click()
    Button().showOff()
    Switch().showOff()
    ClassWithInterfacesWithTheSameMethodName().click()
    ClassWithInterfacesWithTheSameMethodName().showOff()
    ClassWithInterfacesWithTheSameMethodName().setFocus(true)
    ClassWithInterfacesWithTheSameMethodName().setFocus(false)
}