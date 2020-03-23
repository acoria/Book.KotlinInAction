package com.example.kotlininaction

import java.io.File

//Object: a singleton that is instantiated where it is declared
object Payroll{
    val allEmployees = arrayListOf<Person>()

    fun calculateSalary() {
        println("Calculated salary")
        for(person in allEmployees){
            //calculate
        }
    }
}

object CaseInsensitiveFileComparator: Comparator<File>{
    override fun compare(f1: File, f2: File): Int {
        return f1.path.compareTo(f2.path, ignoreCase = true)
    }
}

//nested object (inside a class)
data class AnotherPerson(val name: String){
    object NameComparator: Comparator<AnotherPerson>{
        override fun compare(p1: AnotherPerson, p2: AnotherPerson): Int {
            return p1.name.compareTo(p2.name)
        }
    }
}


fun main() {
//    Payroll.calculateSalary()

    println("${CaseInsensitiveFileComparator.compare(File("/User"), File("/user"))}")
    val files = listOf(File("/Z"), File("/a"))
    println(files.sortedWith(CaseInsensitiveFileComparator))

    val persons = listOf(AnotherPerson("Jane"), AnotherPerson("Bob"))
    println(persons.sortedWith(AnotherPerson.NameComparator))
}
