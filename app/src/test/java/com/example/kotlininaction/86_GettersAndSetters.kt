package com.example.kotlininaction

class Woman(val name: String){
    var address: String = ""
        set(newAdress) {
            println("""
                Address was changed for $name:
                $field -> $newAdress
                    """.trimIndent())
            field = newAdress
        }

}

class LengthCounter{
    //private setter -> property can no longer be changed from outside the class
    var counter: Int = 0
    private set

    fun addWord(word: String){
        counter += word.length
    }
}

fun main() {
    val anita = Woman("Anita")
    anita.address = "str 45, 378 sff"

    val counter = LengthCounter()
    counter.addWord("123456")
    println(counter.counter)
}