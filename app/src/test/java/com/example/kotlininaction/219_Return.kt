package com.example.kotlininaction

//a normal function that returns completely
private val aliceAndFriends = listOf(Human("Alice", 20), Human("Marc", 30))
private val onlyFriends = listOf(Human("Bob", 20), Human("Marc", 30))

fun returnNormallyFromFunToFindAlice(humans: List<Human>) {
    for (human in humans) {
        if (human.name == "Alice") {
            println("Found her!")
            //return returns from function
            return
        }
    }
    println("She doesn't appear to be there")
}

fun returnFromLambdaFunToFindAlice(humans: List<Human>) {
    humans.forEach {
        if (it.name == "Alice") {
            println("Found her!")
            //return returns from lambda&function
            return
        }
    }
    println("She is not here")
}

fun returnLocallyFromLabel(humans: List<Human>) {
    humans.forEach myOwnLabel@{
        if (it.name == "Alice") {
            println("Found her!")
            //return returns behind lambda function declared with own label and
            //execution of function continues
            return@myOwnLabel
        }
    }
    println("Alice might be there..or not..")
}

fun returnByLambdaArgument(humans: List<Human>) {
    humans.forEach {
        if (it.name == "Alice") {
            println("Found her!")
            //return returns from unlabeled label and execution of function continues
            return@forEach
        }
    }
    println("Alice is there..or maybe not..")
}

//The rule for returning is simple: when there is no label defined, return always returns to the
//closest function declared using the fun keyword:

fun lookForAlice(humans: List<Human>){
    println("Looking for Alice")
    humans.forEach {
        //this return returns from the function
        if(it.name == "Alice") return
    }
    println("I will only print when there is no alice")
}

//anonymous functions are used when there is a block of code with multiple exit points to make
//it more readable
fun lookForAliceWithAnonymousFunction(humans: List<Human>){
    println("Looking..")
    humans.forEach( fun (human){
        //this return returns from the anonymous function from the line above
        if(human.name == "Alice") return
    })
    println("I will always print")
}


fun main() {
    returnNormallyFromFunToFindAlice(aliceAndFriends)
    returnNormallyFromFunToFindAlice(onlyFriends)

    returnFromLambdaFunToFindAlice(aliceAndFriends)
    returnFromLambdaFunToFindAlice(onlyFriends)

    returnLocallyFromLabel(aliceAndFriends)
    returnLocallyFromLabel(onlyFriends)

    returnByLambdaArgument(aliceAndFriends)
    returnByLambdaArgument(onlyFriends)

    lookForAlice(aliceAndFriends)
    lookForAlice(onlyFriends)

    lookForAliceWithAnonymousFunction(aliceAndFriends)
    lookForAliceWithAnonymousFunction(onlyFriends)
}