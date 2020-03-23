package com.example.kotlininaction

//companion objects: a place for factory methods and static members

class ModelClass(val name: String){
    companion object Loader{
        fun fromJson(jsonText: String): ModelClass{
            //Json deserializer
            return ModelClass(jsonText)
        }
    }
}

interface JSONFactory<T>{
    fun fromJSON(jsonText: String) : T
}

class AnotherModelClass(val name: String){
    companion object : JSONFactory<AnotherModelClass>{
        override fun fromJSON(jsonText: String): AnotherModelClass {
            return AnotherModelClass(jsonText)
        }
    }
}

fun <T> loadFromJson(factory: JSONFactory<T>, jsonText: String): T{
    return factory.fromJSON(jsonText)
}

fun main() {
    println(ModelClass.Loader.fromJson("{[name: Dimitry]}"))
    println(ModelClass.fromJson("[name: Petrov]"))

    //passes the companion object of the AnotherModelClass class
    loadFromJson(AnotherModelClass, "{[name: Dimitry]}")
}