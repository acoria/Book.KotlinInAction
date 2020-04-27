package com.example.kotlininaction

import java.lang.IllegalArgumentException
import kotlin.reflect.KClass

//The better solution: encapsulate all access to the map into two generic methods responsible for
//having only correct validators registered and returned:
object Validators{
    private val validators = mutableMapOf<KClass<*>, FieldValidator<*>>()

    fun <T: Any> addValidator(kClass: KClass<T>, validator: FieldValidator<T>){
        validators[kClass] = validator
    }
    //Suppresses the warning about the unchecked cast to FieldValidator
    @Suppress("UNCHECKED_CAST")
    fun <T: Any> getValidator(kClass: KClass<T>) : FieldValidator<T>{
        return validators[kClass] as? FieldValidator<T>
            ?: throw IllegalArgumentException("No validator for ${kClass.simpleName}")
    }

    //shorter: use a getter with operator keyword
//    @Suppress("UNCHECKED_CAST")
//    operator <T: Any> get(kClass: KClass<T>) : FieldValidator<T>{
//        return validators[kClass] as? FieldValidator<T>
//            ?: throw IllegalArgumentException("No validator for ${kClass.simpleName}")
//    }
    //lets you access the validators by writing
//    Validators[String::class]

}

fun main() {

    Validators.addValidator(String::class, StringValidator)
    Validators.addValidator(Int::class, IntValidator)
    println(Validators.getValidator(String::class).validate("validates correctly"))
    //now this no longer compiles because of the type mismatch:
    //println(Validators.getValidator(String::class).validate(42))
}