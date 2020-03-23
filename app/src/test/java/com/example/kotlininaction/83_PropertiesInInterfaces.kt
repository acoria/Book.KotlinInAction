package com.example.kotlininaction

interface Monitor{
    val manufacturer: String
}
class Dell: Monitor{
    override val manufacturer: String
        get() = "Dell"
}

interface Access{
    val nickname: String
}
class PrivateAccess(override val nickname: String): Access

class SubscribingAccess(val email: String): Access{
    override val nickname: String
        get() = email.substringBefore('@')
}
class FacebookAccess(val accountId: Int): Access{
    override val nickname: String = getFacebookName(accountId)
    private fun getFacebookName(accountId: Int): String{
        return "name$accountId"
    }
}

interface Man{
    val email: String
    val nickname: String
        get() = email.substringBefore('@')
}
class Jack(override val email: String): Man

fun main() {
    var access: Access

    access = PrivateAccess("my name")
    println(access.nickname)

    access = SubscribingAccess("myEmail@email.com")
    println(access.nickname)

    access = FacebookAccess(1234567)
    println(access.nickname)

    val jack: Man = Jack("jack@noneofyourbusiness.com")
    println(jack.nickname)
}