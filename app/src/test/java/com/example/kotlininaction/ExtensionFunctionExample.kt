package strings

import com.example.kotlininaction.Person

fun String.lastChar(): Char = get(length - 1)



fun Person.isFemale() = name.length > 5
fun main() {
    val person = Person("Jack")


    val isFemaleFunction = Person::isFemale
    println(isFemaleFunction(person))

    //this is a bound member reference since is is bound to one person
    val boundMemberFunction = person::isFemale
    println(boundMemberFunction())
}