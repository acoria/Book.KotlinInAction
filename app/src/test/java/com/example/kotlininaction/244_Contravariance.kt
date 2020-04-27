package com.example.kotlininaction


open class Cutlery(val number: Int)
class Knife(num: Int) : Cutlery(num)

//Contravariant classes have a reversed type compared to a covariant one
//If you define a function with a contravariant input parameter, you can not only use the
//type but also its supertypes:
//e.g.:

fun getPositionOfKnife(knife: Knife, func: (Knife) -> Int): Number {
    return func(knife)
}
fun Cutlery.getPosition(): Int {
    return number + 1
}

fun main() {
    //in getPositionOfKnife, Knife is defined as the input parameter in the func-function
    //but since it was defined as contravariant(see Function1 interface) cutlery can also be used.
    //The returning parameter is covariant, so instead of Number, the subtype Int can be used.
    getPositionOfKnife(Knife(5)) {c: Cutlery -> c.getPosition()}
    getPositionOfKnife(Knife(4), Cutlery::getPosition)
}

//this is Kotlin's definition of a one-parameter function:
//P is contravariant, R is covariant
interface Function1<in P, out R>{
    operator fun invoke(p: P) : R
}

//MutableList in Kotlin defined the following:
//MutableList<in T>
//correlates to this in Java:
//MutableList<? super T>
