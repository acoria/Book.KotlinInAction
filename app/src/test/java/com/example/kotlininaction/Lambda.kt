package com.example.kotlininaction

//Lambdas can be used as an alternative to an anonymous object with only one method

fun executeLambdasOption1() {
    val sum = { x: Int, y: Int -> x + y }
    println(sum(1, 3))
}

fun executeLambdasOption2() {
//    { println(23) }()
//    { x: Int, y: Int -> println(x + y) }(5, 6)
}

fun executeLambdasOption3(){
    //Run runs the code inside of the lambda -> not really readable
    run { println(4) }
}
data class Human(val name: String, val age: Int)
val people = listOf(
    Human("Alice", 29),
    Human("Bob", 31)
)

fun lambdaNotation(){

    //short notation
    people.maxBy{ it.age }
    //long notation
    people.maxBy({ p: Human -> p.age })
    //the last argument of a function call can be moved out of the parentheses -> here there is only one argument in maxBy-function
    people.maxBy() { p: Human -> p.age }
    //when the lambda is the only argument to a function, the empty parentheses can be removed
    people.maxBy { p: Human -> p.age}

    //mentioning the name of the parameter is not necessary with only one parameter
    people.maxBy( selector = {p: Human -> p.age} )
    //different notation (if lambda delegates to a function or property, it can be replaced by a member reference)
    people.maxBy(Human::age)
}

fun main() {

//    executeLambdasOption1()
//    executeLambdasOption3()

//    println(
//        myFunWithLambdas(
//            Human(
//                "John",
//                45
//            ), { p: Human -> p.age })
//    )
//    println(
//        myFunWithLambdas(
//            Human(
//                "John",
//                45
//            )
//        ) { p: Human -> p.age })
//    println(
//        myFunWithLambdas(
//            Human(
//                "John",
//                45
//            )
//        ) { it.age })
//    println(
//        myFunWithLambdasParantheses(
//            { it.age },
//            Human("Jack", 20)
//        )
//    )

//    println(people.joinToString(separator = ", ", transform = { p -> p.name }))
//    println(people.joinToString("; ") { p -> p.name })
//    println(people.joinToString { p -> p.name })
//    println(people.joinToString { p: Human -> p.name })


    //pass an argument, that is already declared as a function
    println(people.joinToString(transform = Human::name))
    val humanAgeLambda = { h: Human -> h.name }
    println(people.joinToString(transform = humanAgeLambda))

    val humanAge = Human::name
    println(people.joinToString(transform = humanAge))
    run(::salute)
}

fun salute(){
    println("Salute!")
}

fun myFunWithLambdas(human: Human, ageDeterminator: (Human) -> Int) : Int{
    return ageDeterminator(human)
}
fun myFunWithLambdasParantheses(ageDeterminator: (Human) -> Int, human: Human) : Int{
    return ageDeterminator(human)
}

