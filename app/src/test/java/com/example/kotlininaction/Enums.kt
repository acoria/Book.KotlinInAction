package com.example.kotlininaction

import com.example.kotlininaction.Plant.*
import java.util.*

fun main(){
    println("Blue: ${Color.BLUE.rgb()}")
    println("Green: ${Color.GREEN.rgb()}")
    println("Red: ${Color.RED.rgb()}")
    println(whatPlantAreYou(PALM))

    println(setOfPlants == anotherSetOfPlants)
    println(growAHybrid(TREE, PALM))
    println(getANumber(NumberClass()))
}

enum class Color(val r: Int, val g: Int, val b: Int){
    BLUE(0,0,255),
    GREEN(0,255,0),
    RED(255, 0,0);

    fun rgb() = (r*256 + g) * 256 + b
}

enum class Plant(private val size: Int){
    TREE(20),
    PALM(50),
    FLOWER(1),
    ORCHID(5);

    fun isBig() = size > 5
}

fun whatPlantAreYou(plant: Plant) =
    when(plant){
        TREE, PALM -> "It is a tree"
        FLOWER -> "It is a flower"
        ORCHID -> "It is an orchid"
    }

val setOfPlants: Set<Plant> = setOf(TREE, FLOWER)
val anotherSetOfPlants = setOf(FLOWER, TREE)

fun growAHybrid(plantA: Plant, plantB: Plant): String{
    return when(setOf(plantA, plantB)){
        setOf(TREE, PALM) ->"Tree&Palm"
        setOf(FLOWER, TREE) -> "Flower&Tree"
        else -> "MonsterTree"
    }
}
class NumberClass{
    val number = Random().nextInt()
}

fun getANumber(number: NumberClass): String{
    return when(number.number > 50){
         true -> "big ${number.number}"
         false -> "small ${number.number}"
    }
}