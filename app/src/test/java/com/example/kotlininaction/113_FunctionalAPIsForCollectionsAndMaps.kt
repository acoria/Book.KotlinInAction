package com.example.kotlininaction

data class Being(val name: String, val age: Int)
data class Book(val title: String, val authors: List<String>)

val beings = listOf(Being("Bob", 31), Being("Sarah", 28), Being("John", 31))
fun main() {

//    playWithCollections()
//    playWithMaps()
//    predicatesForCollections()
//    flatTheMap()
    flatTheBooks()
}


fun flatTheBooks() {
    val books = listOf(
        Book("The book of the 1000 words", listOf("Some Author")),
        Book("The book of a million words", listOf("Another Author", "A third author")),
        Book("The book of 100 pics", listOf("Some Author", "A third author")))

    println(books.flatMap { it.authors })
    println(books.flatMap { it.authors }.toSet())

    val listOfNumbers = listOf(
        listOf(1,2,3),
        listOf(4,5,6),
        listOf(7,8,9))
    println(listOfNumbers.flatten())
}


private fun flatTheMap() {
    val strings = listOf("abc", "def")
    println("${strings.flatMap { it.toList() }} <- flatMapped")
}

private fun predicatesForCollections() {

    val list = listOf(1,2,3)
    println("${list.any { it > 2 }}  <- any bigger than 2?")
    println("${list.all { it > 2 }} <- all bigger than 2?")
    println("${list.any { it != 2 }} <- any element not 3?")

    val canBeInClub31 = { b: Being -> b.age >= 31 }
    println(beings.filter(canBeInClub31).map{ it.name })
    println("${beings.count()} <- total")
    println("${beings.count(canBeInClub31)} <- over 31")
    println("${beings.find(canBeInClub31)} <- find a being club member")
    println("${beings.groupBy { it.age }} <- grouped by age")
}

private fun playWithMaps() {
    val numbers = mapOf(0 to "zero", 1 to "one")
    println("$numbers <- original")

    println("${numbers.mapValues { it.value.toUpperCase() }} <- mapped values")
    println("${numbers.filterValues { it.length > 3}} <- filtered values")
    println("${numbers.filterKeys { it > 0 }} <- filtered keys")
    println("${numbers.mapKeys { it.key + 10 }} <- mapped keys")
}

private fun playWithCollections() {

    var newBeingsNames = beings
        .filter { it.age >= 31 }
        .map(Being::name)
    println(newBeingsNames)

    val maxAge = beings.maxBy(Being::age)!!.age
    val newBeings = beings.filter { it.age == maxAge }
    println(newBeings)
}