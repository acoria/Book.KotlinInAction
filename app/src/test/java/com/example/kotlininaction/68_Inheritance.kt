package com.example.kotlininaction

open class Base{
    fun click(){ println("Click")}
}

open class Parent: Base(){

    fun cannotBeOverridden(){ }
    open fun canBeOverridden(){}
    open fun canOnlyBeOverriddenOnce(){}
}

open class Child: Parent(){
    override fun canBeOverridden() {
        //so something else
    }

    final override fun canOnlyBeOverriddenOnce() {
        //you will not override me again!
    }
}

class TheLastChild: Child()

abstract class AbstractClass{
    //final keyword is unnecessary, final by default
    fun nonAbstractMethod(){
        //doing something
    }
    open fun abstractMethodToOverride(){
        //this method can be overridden
    }
}
class NonAbstractClass: AbstractClass(){
    override fun abstractMethodToOverride() {
        //do something else
    }
}