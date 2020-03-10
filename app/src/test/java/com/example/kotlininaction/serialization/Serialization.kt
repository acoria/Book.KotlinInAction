package com.example.kotlininaction.serialization

class OuterClass{

    val name = ""

    inner class InnerClass{
        fun doSomething(){
            //inner classes have a reference to their outer class
            this@OuterClass.name
        }
    }
    class NestedClass{
        //nested classes do not have a reference to their outer class
    }
}