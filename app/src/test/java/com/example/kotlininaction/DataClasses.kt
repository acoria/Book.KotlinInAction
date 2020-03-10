package com.example.kotlininaction

private class Client(val name: String, val postalCode: Int){
    override fun toString(): String = "${super.toString()}  - Client(name=$name, postalCode=$postalCode)"
    override fun equals(other: Any?): Boolean {
        if(other == null || other !is Client){
            return false
        }
        return name == other.name && postalCode == other.postalCode
    }

    override fun hashCode(): Int {
        return name.hashCode() * 31 + postalCode
    }
}

private data class ClientAsDataClass(val name: String, val postalCode: Int)

fun main(){

//    checkClientClass()

    var client1 = ClientAsDataClass("abc",123)
    var client2 = ClientAsDataClass("abc",123)

    println(client1)
    println(client2)

    if(client1.equals(client2)){
        println("equal")
    }else println("unequal")

    val processed = hashSetOf(ClientAsDataClass("Alice", 123))
    println("${processed.contains(ClientAsDataClass("Alice", 123))}")


}

private fun checkClientClass() {
    println("${Client("someName", 123)}")

    var client1 = Client("abc", 123)
    var client2 = Client("abc", 123)

    println(client1)
    println(client2)

    if (client1.equals(client2)) {
        println("equal")
    } else println("unequal")

    val processed = hashSetOf(Client("Alice", 123))
    println("${processed.contains(Client("Alice", 123))}")
}