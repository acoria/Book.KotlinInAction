package com.example.kotlininaction

class Food constructor(_name: String){
    val name = _name
}
class Food2 (_name: String){
    init{
        val name = _name
    }
}

class Food3(val name: String,
            val age: Int = 0)

//name is a private property
class Fruit(name: String)

//name is a read-only property
class Veggi(val name: String)

//name has getter and setter
open class Meat(var name: String)

class Sausage(val from: String): Meat("Chorizo")

open class Bread
class BreadBun private constructor(): Bread(){
    fun getInstance(): BreadBun{
        return BreadBun()
    }
}


fun main() {
    val food = Food("Sausage")
    val fruit = Fruit("Banana")
    Bread()
}