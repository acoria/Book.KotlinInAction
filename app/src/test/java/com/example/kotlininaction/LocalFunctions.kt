package com.example.kotlininaction

import java.lang.IllegalArgumentException
import java.util.*

class User(val id: Int, val name: String, val address: String)

fun saveUser(user:User){
    if (user.name.isEmpty()){
        throw IllegalArgumentException(
            "Can't save user ${user.id}: empty Name"
        )
    }
    if (user.address.isEmpty()){
        throw IllegalArgumentException(
            "Can't save user ${user.id}: empty Address"
        )
    }

    //save user to DB
}

fun saveUserWithLocalFunction(user: User){
    fun validate(value: String,
                 fieldName: String){
        if(value.isEmpty()){
            throw IllegalArgumentException(
                "Can't save user ${user.id}: empty $fieldName")
        }
    }
    validate(user.name, "Name")
    validate(user.address, "Address")

    //save user to DB
}

//validation function as extension function
fun User.validateBeforeSave(value: String, fieldname: String){
    if(value.isEmpty()){
        throw IllegalArgumentException(
            "Can't save user $id: empty $fieldname - from extension function"
        )
    }
}

fun main() {
//    saveUser(User(1, "" , ""))
//    saveUserWithLocalFunction(User(1, "dfghjk" , ""))
    val name = "the name"
    val address = "the addreess"
    val user = User(1, name, address)
    user.validateBeforeSave("", name)
}