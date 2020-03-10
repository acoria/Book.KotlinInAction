package com.example.kotlininaction

class PersonTest(var firstname: String, var lastname: String){

    val id: Int

    init{id = nextId++}

    private companion object{
        var nextId = 1
    }
}
class PersonDao{
    private var persons = mutableListOf(PersonTest("Sheldon", "Shark"), PersonTest("Jimmy", "Jellyfish"))

    fun findPersonById(id: Int): PersonTest?{
        return persons.find { person -> person.id == id }
    }

    fun getAll(): List<PersonTest>{
        return persons
    }

    fun addPerson(person: PersonTest){
        persons.add(person)
    }

    fun deleteById(id: Int): PersonTest?{
        val person = findPersonById(id)
        if(person != null){
            persons.remove(person)
        }
        return person
    }
}

class PersonController{
    private val personDao = PersonDao()

    fun getPersons(): List<PersonTest>{
        return personDao.getAll()
    }
}
