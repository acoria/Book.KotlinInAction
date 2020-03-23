package com.example.kotlininaction

class SomeUserWithRegularConstructors {
    val nickname: String

    //regular constructors
    constructor(email: String) {
        nickname = email.substringBefore('@')
    }

    constructor(facebookAccountId: Int) {
        nickname = "facebook name by id"
    }

}
class SomeUserWithCompanionObject private constructor(val nickname: String){
    //factory method by companion object
    companion object{
        fun newSubscribingUser(email: String){
            SomeUserWithCompanionObject(email.substringBefore('@'))
        }
        fun newFacebookUser(accountId: Int){
            SomeUserWithCompanionObject("facebook name by id")
        }
    }
}

fun main() {
    (SomeUserWithCompanionObject.newFacebookUser(123) as SomeUserWithCompanionObject).nickname
    SomeUserWithCompanionObject.newSubscribingUser("myname@email.com")
    println(SomeUserWithRegularConstructors("myname@email.com").nickname)
}