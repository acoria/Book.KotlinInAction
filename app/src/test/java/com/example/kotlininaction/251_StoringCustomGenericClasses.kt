package com.example.kotlininaction

import java.lang.IllegalArgumentException
import java.lang.reflect.Field
import kotlin.reflect.KClass

    //A common trap with using star projection:
//Imagine you need to validate user input and you declare an interface FieldValidator.
//It contains its type parameter in the in position only, so it can be declared as contravariant.
    interface FieldValidator<in T> {
        fun validate(input: T): Boolean
    }

    object StringValidator : FieldValidator<String> {
        override fun validate(input: String) = input.isNotEmpty()
    }

    object IntValidator : FieldValidator<Int> {
        override fun validate(input: Int): Boolean = input >= 0
    }

fun main() {
    //Now you want to store all validators in the same container and get the right validator
    //according to the type of input. You could use a map to store them. You need to store
    //validators for any types, so you declare a map from KClass to FieldValidator<*>
    val validators = mutableMapOf<KClass<*>, FieldValidator<*>>()

    //you add your validators
    validators[String::class] = StringValidator
    validators[Int::class] = IntValidator

    //now you might have difficulties when trying to use the validators. The value stored in the
    //map for the Validator is FieldValidator<*> so the compiler does not know which kind of
    //validator it is.
    //This does not compile, since it is unsafe to give a value of a specific type to a validator
    //for an unknown type:
    //validators[String::class]!!.validate("")

    //one solution would be casting -> results in a warning "unchecked cast"
    val stringValidator = validators[String::class] as FieldValidator<String>
    println(stringValidator.validate(""))

    //so if you make a mistake..it compiles
    val errorStringValidator = validators[Int::class] as FieldValidator<String>
    //but will cause a runtime exception when trying to cast String to Int
    println(errorStringValidator.validate(""))

    //..see next file for a better solution
}