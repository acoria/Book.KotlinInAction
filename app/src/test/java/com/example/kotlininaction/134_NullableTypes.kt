package com.example.kotlininaction

class Address(val street: String, val zipCode: Int,
              val city: String, val country: String)

class Company(val name: String, val address: Address?)

class Employee(val name: String, val company: Company?)


//verbose
fun Employee.countryName(): String?{
    val country = this.company?.address?.country
    return if (country != null) country else "Unknown"
}

//shorter with Elvis operator -> ?: (turn your head and you can see him come to life)
//or call it more serious-sounding "null-coalescing operator"
fun Employee.countryNameElvised(): String?{
    val country = this.company?.address?.country
    return country ?: "Unknown"
}

fun Employee.countryNameElvisedShorter() =
    company?.address?.country ?: "Unknown"

fun stringLengthSave(s: String?): Int =
    if (s != null) s.length else 0

fun stringLengthSaveElvis(s: String?): Int = s?.length ?: 0

fun main() {
    println(Employee("Bob", null).countryName())
    println(Employee("Bob", null).countryNameElvised())
    println(stringLengthSave("abc"))
    println(stringLengthSave(null))
    println(stringLengthSaveElvis(null))
}