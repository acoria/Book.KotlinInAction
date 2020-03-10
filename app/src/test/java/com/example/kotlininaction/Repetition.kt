package com.example.kotlininaction

class SomeClass(val name: String, var age: Int)

enum class SkiEquipment(val equipment: String){
    SKI("Ski"),
    SNOWBOARD("Snowboard"),
    BIGFOOTS("Bigfoots");

    fun isCoolEquipment(): Boolean{
        return when(this){
            SKI, BIGFOOTS -> false
            SNOWBOARD -> true
        }
    }
    fun isCool(): Boolean = when(this){
        SNOWBOARD -> true
        else -> false
    }
}

class Snowboard(val length: Int){
    val isMaleVersion: Boolean
        get() = length > 155

    fun move(speed: Int): String = if(speed > 65) "Going max speed of 65,4km/h" else "Going $speed km/h"
}

fun main() {

    val equips = setOf(SkiEquipment.SNOWBOARD, SkiEquipment.BIGFOOTS, SkiEquipment.SKI)
    println(equips.size)
    //TODO
//    equips.forEach(printEquipment())

//    println(maxNumberAsExpression(4,5))
//    println(maxNumberAsBlock(5,4))
//    testSomeClass()
//    println(Snowboard(166).isMaleVersion)
//    println(Snowboard(154).move(76))
//    println(SkiEquipment.BIGFOOTS.equipment)
//    println("${SkiEquipment.SNOWBOARD} : Are you cool? -> ${SkiEquipment.SNOWBOARD.isCoolEquipment()}")
//    println("${SkiEquipment.SNOWBOARD} : Are you cool? -> ${SkiEquipment.SNOWBOARD.isCool()}")
}

//fun printEquipment(): (SkiEquipment) -> Unit {
//    //???
//}

private fun testSomeClass() {
    val someClass = SomeClass("Jack", 6)
    someClass.age = 4
    println(someClass.age)
    println("Name: ${someClass.name}")
}

fun maxNumberAsBlock(a: Int, b: Int): Int{
    return if(a > b) a else b
}
fun maxNumberAsExpression(a: Int, b: Int): Int = if(a > b) a else b