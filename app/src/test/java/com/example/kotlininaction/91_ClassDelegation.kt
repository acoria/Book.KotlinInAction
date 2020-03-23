package com.example.kotlininaction

//p.91: Class delegation
//mit "by" werden alle Methodenaufrufe an die übergebene Klasse weitergereicht

interface IAnimal{
    fun kick()
    fun run()
}
class Horse: IAnimal{
    override fun kick() {
        println("Kick")
    }

    override fun run() {
        println("Run")
    }
}

class Pegasus(val innerHorse: IAnimal): IAnimal by innerHorse{
    override fun run() {
        println("Fly")
    }
}

fun main() {
    Horse().run()
    Pegasus(Horse()).run()
}