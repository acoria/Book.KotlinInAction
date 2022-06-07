package com.example.kotlininaction

class Person(val name: String)
private class Animal(val name: String, var isOld: Boolean = true)

fun main(){
    testPerson()
    testAnimal()
}

fun testAnimal() {
    val animal = Animal("Bobo")
    println("animal: ${animal.name} - age: ${animal.isOld}")
    animal.isOld = false
    println("animal: ${animal.name} - age: ${animal.isOld}")
}

fun testPerson(){
    val person = Person("Jack")
    println(person.name)
}

fun testJavaClassHouse(){
    val house = House("yellow", true)
    house.isEmpty = false
}