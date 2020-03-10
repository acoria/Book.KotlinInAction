package com.example.kotlininaction


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